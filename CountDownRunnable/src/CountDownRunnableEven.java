public class CountDownRunnableEven implements Runnable {
    public void run() {
        Thread t = Thread.currentThread();
        for (int i = 10; i > 0; i-=2) {
            System.out.println(t.getName() + " - Count: " + i);
            // Thread.yield();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("caught one - even");
            }
        }
    }
}
