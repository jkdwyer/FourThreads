public class CountDownOdd extends Thread {
    public void run() {
        for (int i = 9; i > 0; i-=2) {
            System.out.println(this.getName() + " - Count: " + i);
            Thread.yield();
        }
    }
}
