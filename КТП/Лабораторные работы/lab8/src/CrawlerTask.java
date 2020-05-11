import java.io.IOException;

public class CrawlerTask implements Runnable {

    private URLPool urlPool;
    private URLDepthPair urlDepthPair;
    private Crawler crawler;

    public CrawlerTask(URLPool pool) {
        urlPool = pool;
        crawler = new Crawler();
    }

    public void run() {
        while (true) {
            urlDepthPair = urlPool.getURL();
            try {
                urlPool.addListURL(crawler.work(urlDepthPair, 80));
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
