package lt.vianet.telia.rss.spring;

import lt.vianet.telia.rss.actions.Actions;
import lt.vianet.telia.rss.io.DateFormatConverter;
import lt.vianet.telia.rss.rss_feeds.RssFeed;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


@Controller
public class SpringController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Locale locale, Model model) {

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        RssFeed rssFeed = getRssData();
        model.addAttribute("rssFeed", rssFeed);

        model.addAttribute("updateTime", getFormatedDate(rssFeed.getUpdateTime()));

        return "index";
    }

    private RssFeed getRssData() {
        return new Actions().startApp();
    }

    private String getFormatedDate(Date rawDate) {

        return new DateFormatConverter(rawDate).getFormatedDate();
    }
}
