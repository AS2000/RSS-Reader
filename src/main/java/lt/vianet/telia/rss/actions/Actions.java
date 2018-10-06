package lt.vianet.telia.rss.actions;

import lt.vianet.telia.rss.rss_feeds.RssFeed;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class Actions {

    @PostConstruct
    public RssFeed startApp() {

        return doActions();
    }

    private RssFeed doActions() {

        RssFeed rssFeed = new DataFromNewsPageRSS("https://www.15min.lt/rss", "15min.lt").doActions();

        //TODO delete print
//        new PrintAll().PrintArray(rssFeed);
        return rssFeed;
    }
}
