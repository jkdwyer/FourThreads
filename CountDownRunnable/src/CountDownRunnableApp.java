public class CountDownRunnableApp {
    public static void main(String args[]) {
        System.out.println("in CountDownRunnableApp.main");
        Thread count3 = new Thread(new CountDownRunnableEven());
        Thread count4 = new Thread(new CountDownRunnableOdd());
        count3.start();
        count4.start();
    }
}
