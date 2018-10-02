package lt.vianet.telia.rss.rss_feeds;

import java.net.MalformedURLException;
import java.net.URL;

public class Article implements IArticle {
    private String title;
    private URL url;

    public Article() {
    }

    public Article(String title, String feedURL) {
        try {

            this.title = title;
            this.url = new URL(feedURL);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}



