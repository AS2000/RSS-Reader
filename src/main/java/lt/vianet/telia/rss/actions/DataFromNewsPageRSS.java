package lt.vianet.telia.rss.actions;

import lt.vianet.telia.rss.io.RSSFeedExtraction;
import lt.vianet.telia.rss.rss_feeds.RssFeed;


public class DataFromNewsPageRSS {

    private final String url;
    private final String feedName;

    public DataFromNewsPageRSS(String feedURL, String feedName) {
        this.url = feedURL;
        this.feedName = feedName;
    }


    public RssFeed doActions() {

        return getDataFromNewsPageRSS();
    }

    private RssFeed getDataFromNewsPageRSS() {

        return new RSSFeedExtraction(url, feedName).getDataFromRSSFeed();

    }
}

