package lt.vianet.telia.rss.rss_feeds;


import java.net.URL;

public interface IArticle {

    public String getTitle();

    public void setTitle(String title);

    public URL getUrl();

    public void setUrl(URL url);
}
