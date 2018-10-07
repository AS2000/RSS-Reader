package lt.vianet.telia.rss.rss_feeds;

import java.net.URL;
import java.util.Date;
import java.util.List;

public interface IRssFeed {

    public String getName();

    public URL getUrl();

    public Date getUpdateTime();

    public void setUpdateTime(Date updateTime);

    public List<Article> getArticles();


}
