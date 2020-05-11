import java.util.*;

public class URLPool {
    private LinkedList<URLDepthPair> untreated; //необработанные
    private LinkedList<URLDepthPair> treated; //обработанные

    private int finalDepth;

    private int waitThreads = 0;

    URLPool(URLDepthPair url,int depth){
        finalDepth=depth;
        untreated = new LinkedList<URLDepthPair>();
        treated = new LinkedList<URLDepthPair>();
        untreated.add(url);
    }

    public synchronized int getWaitThreads() {
        return waitThreads;
    }

    public synchronized URLDepthPair getURL(){
        if (untreated.size() == 0) {
            try {
                waitThreads++;
                this.wait();
            }
            catch (InterruptedException e) {
                System.err.println("MalformedURLException: " + e.getMessage());
                return null;
            }
        }
        treated.add(untreated.getFirst());
        return untreated.removeFirst();
    }

    public synchronized void addListURL(LinkedList<URLDepthPair> URLs){

        if (URLs.size()!=0){
            if (URLs.getFirst().depth>=finalDepth){
                treated.addAll(URLs);
            }
            else{
                untreated.addAll(URLs);
                for (int countSite=URLs.size(); countSite!=0 && waitThreads!=0;countSite-- , waitThreads--){
                    this.notify();
                }
            }
        }
    }

    public LinkedList<URLDepthPair> getSite(){
        return treated;
    }
}
