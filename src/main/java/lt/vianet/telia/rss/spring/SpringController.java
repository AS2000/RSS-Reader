package lt.vianet.telia.rss.spring;

import lt.vianet.telia.rss.actions.Actions;
import lt.vianet.telia.rss.io.DateFormatConverter;
import lt.vianet.telia.rss.rss_feeds.FeedLink;
import lt.vianet.telia.rss.rss_feeds.IFeedLink;
import lt.vianet.telia.rss.rss_feeds.IRssFeed;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


@Controller
public class SpringController {

    List<IRssFeed> rssFeedList = new ArrayList<IRssFeed>();

    public SpringController() {
        this.rssFeedList = rssFeedList;
        // Setting Default RSS Feed
        rssFeedList.add(getRssData("https://www.15min.lt/rss", "15min.lt"));
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String feedList(Locale locale, Model model) {

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate);

        model.addAttribute("rssFeedList", rssFeedList);

        return "feedlist";
    }


    @RequestMapping("/feed/feedlist")
    public String toFeedList() {
        return "redirect:/";
    }


    @RequestMapping(value = "/feed/{id}", method = RequestMethod.POST)
    public String feed(@PathVariable("id") int id, Model model) {

        model.addAttribute("rssFeed", rssFeedList.get(id));
        model.addAttribute("updateTime", getFormatedDate(rssFeedList.get(id).getUpdateTime()));

        return "feedpage";
    }


    @RequestMapping("/newfeed")
    public String newFeed() {
        return "addfeed";
    }


    @ModelAttribute("feed")
    public FeedLink createFeed() {
        return new FeedLink();
    }


    @RequestMapping(value = "/addfeed", method = RequestMethod.POST)
    public String addFeed(@ModelAttribute("feed") IFeedLink feed, BindingResult result) {

        // By default, Spring MVC throws an exception when errors occur during request binding. This usually not what we want, instead, we should be presenting these errors to the user.
        if (result.hasErrors()) {
            return "error";
        }
        if (!feed.getName().isEmpty() && !feed.getUrl().isEmpty()) {

            // Adding new RSSFeed Object
            IRssFeed rssFeed = getRssData(feed.getUrl().trim(), feed.getName().trim());
            if (rssFeed != null) {
                rssFeedList.add(rssFeed);
            } else {
                return "redirect:/errorpage";
            }
        }
        return "redirect:/";
    }


    @RequestMapping("errorpage")
    public String errorFeed() {
        return "error";
    }


    @RequestMapping("/feed/remove/{id}")
    public String removeFeed(@PathVariable("id") int id) {

        if (rssFeedList.get(id) != null) {

            // Adding new RSSFeed Object
            rssFeedList.remove(id);
        }

        return "redirect:/";
    }


    private IRssFeed getRssData(String feedURL, String feedName) {
        return new Actions(feedURL, feedName).startApp();
    }


    private String getFormatedDate(Date rawDate) {

        return new DateFormatConverter(rawDate).getFormatedDate();
    }
}
