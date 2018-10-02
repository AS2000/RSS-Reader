package lt.vianet.telia.rss.rss_feeds;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RssFeed {

    private String name;
    private URL url;
    private Date updateTime;
    private List<Article> articles = new ArrayList<Article>();

    public RssFeed() {
    }

    public RssFeed(String name, URL url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public URL getUrl() {
        return url;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<Article> getArticles() {
        return articles;
    }


}
