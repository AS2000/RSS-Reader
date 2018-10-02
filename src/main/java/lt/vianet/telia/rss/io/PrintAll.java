package lt.vianet.telia.rss.io;

import lt.vianet.telia.rss.rss_feeds.RssFeed;

public class PrintAll {
    public void PrintArray(RssFeed rssFeed){

        System.out.println("Feed Name: " + rssFeed.getName());
        System.out.println("URL address: " + rssFeed.getUrl());
        System.out.println("Update time: " + rssFeed.getUpdateTime());
        System.out.println("Articles:");
        for (int i = 0; i < rssFeed.getArticles().size(); i++) {
            System.out.println("" + (i+1) + ".");
            System.out.println("Article Tile: " + rssFeed.getArticles().get(i).getTitle());
            System.out.println("Article Link: " + rssFeed.getArticles().get(i).getUrl());
        }

    }
}
