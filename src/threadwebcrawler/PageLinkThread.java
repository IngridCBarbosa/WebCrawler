package threadwebcrawler;


/**
 *
 * @author Ingrid
 */
public class PageLinkThread implements Runnable {

    private String urlLink;

    public PageLinkThread(String urlLink) {
        this.urlLink = urlLink;

    }

    @Override
    public void run() {
        WebCrawler wc;
        wc = new WebCrawler();
        wc.getPageLinks(urlLink);
        wc.download();
    }
}
