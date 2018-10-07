package lt.vianet.telia.rss.actions;

import lt.vianet.telia.rss.rss_feeds.RssFeed;

public class Actions {
    private final String feedURL;
    private final String feedName;

    public Actions(String feedURL, String feedName) {
        this.feedURL = feedURL;
        this.feedName = feedName;
    }
    public RssFeed startApp() {

        return doActions();
    }

    private RssFeed doActions() {

        RssFeed rssFeed = new DataFromNewsPageRSS(feedURL, feedName).doActions();

        //TODO delete print
//        new PrintAll().PrintArray(rssFeed);
        return rssFeed;
    }
}
