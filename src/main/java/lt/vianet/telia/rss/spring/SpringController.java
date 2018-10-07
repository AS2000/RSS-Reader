package lt.vianet.telia.rss.spring;

import lt.vianet.telia.rss.actions.Actions;
import lt.vianet.telia.rss.io.DateFormatConverter;
import lt.vianet.telia.rss.rss_feeds.IFeedLink;
import lt.vianet.telia.rss.rss_feeds.IRssFeed;
import lt.vianet.telia.rss.rss_feeds.RssFeed;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


    @RequestMapping(value = "/feed/${id}", method = RequestMethod.GET)
    public String feed(@PathVariable("id") int id, Model model) {

        model.addAttribute("rssFeed", rssFeedList.get(id));
        model.addAttribute("updateTime", getFormatedDate(rssFeedList.get(id).getUpdateTime()));

        return "feed";
    }


    @RequestMapping(value = "/addfeed", method = RequestMethod.POST)
    public String addFeed(@ModelAttribute("feed") IFeedLink feed) {

        if (!feed.getName().isEmpty() && !feed.getUrl().isEmpty()) {

            // Adding new RSSFeed Object
            rssFeedList.add(getRssData(feed.getUrl().trim(), feed.getName().trim()));
        }

        return "redirect:/";
    }


    @RequestMapping(value = "/remove/${id}", method = RequestMethod.POST)
    public String removeFeed(@PathVariable("id") int id) {

        if (rssFeedList.get(id) != null) {

            // Adding new RSSFeed Object
            rssFeedList.remove(id);
        }

        return "redirect:/";
    }


    private RssFeed getRssData(String feedURL, String feedName) {
        return new Actions(feedURL, feedName).startApp();
    }


    private String getFormatedDate(Date rawDate) {

        return new DateFormatConverter(rawDate).getFormatedDate();
    }
}
