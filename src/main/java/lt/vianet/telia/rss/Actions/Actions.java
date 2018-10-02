package lt.vianet.telia.rss.Actions;

import lt.vianet.telia.rss.io.PrintAll;
import lt.vianet.telia.rss.rss_feeds.RssFeed;

public class Actions {

    public void startApp() {

        doActions();
    }

    private void doActions() {

        RssFeed rssFeed = new DataFromNewsPageRSS("https://www.15min.lt/rss", "15min.lt").doActions();

        //TODO delete print
        new PrintAll().PrintArray(rssFeed);
    }
}
