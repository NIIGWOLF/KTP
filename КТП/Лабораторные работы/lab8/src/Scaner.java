import java.util.*;
public class Scaner {
    static LinkedList<URLDepthPair> site;

    public static void main(String[] args){
        String startURL=args[0];
        String fDepth=args[1];
        String cThread=args[2];
        //String startURL="http://www.google.com";
        //String fDepth="3";
        //String cThread="4";


        URLDepthPair startUrl = new URLDepthPair(startURL,0);

        if (fDepth.matches("\\D+") || !startUrl.isURL() || cThread.matches("\\D+")) {
            System.out.println("java Crawler <" + startURL + "><" + fDepth + "><" + cThread + ">");
            return;
        }

        int finalDepth=Integer.parseInt(fDepth);
        int countThread=Integer.parseInt(cThread);


        URLPool pool = new URLPool(startUrl,finalDepth);

        LinkedList<Thread> threadList = new LinkedList<>();

        for (int i=0;i<countThread;i++){
            CrawlerTask crawlerTask = new CrawlerTask(pool);
            threadList.add(new Thread(crawlerTask));
            threadList.getLast().start();
        }

        while (pool.getWaitThreads()!=countThread){
            System.out.print("");
        }

        site=pool.getSite();

        for(URLDepthPair url: site){
            System.out.println(url);
        }

        for(Thread thread: threadList){
            thread.stop();
        }
    }
}
