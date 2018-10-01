package lt.vianet.telia.rss.Actions;

public class Actions {

    public void startApp() {

        doActions();
    }

    private void doActions() {

        new News15MinRSS().doActions();
    }
}
