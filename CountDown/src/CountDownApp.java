/**
 * CountDownApp class
 * - From JSE6 Ch 14 on Threads.
 * - Main is one, even is one, odd is one, total three threads.
 */
public class CountDownApp {
    public static void main(String args[]) {
        System.out.println("in CountDownApp.main");
        Thread count1 = new CountDownEven();
        Thread count2 = new CountDownOdd();
        count1.setPriority(Thread.MIN_PRIORITY);
        count2.setPriority(Thread.MAX_PRIORITY);
        count1.start();
        count2.start();
    }
}
