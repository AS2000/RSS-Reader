package lt.vianet.telia.rss.rss_feeds;


public class FeedLink implements IFeedLink {

    private String name;
    private String url;

    public FeedLink() {
    }

    public FeedLink(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
