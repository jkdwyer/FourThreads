public class OrderHandler extends Thread {
    private OrderQueue orderQueue;

    // my addition:
    private boolean carryOn = true;
    private volatile boolean running = true;
    private static int numberOfOrders = 0;
    private int sleepCount = 0;

    public OrderHandler(OrderQueue orderQueue) {
        this.orderQueue = orderQueue;
    }

    public void run() {
        Order order;

        synchronized (OrderQueue.class) {
            numberOfOrders++;
            System.out.println("\tnumberOfOrders: " + numberOfOrders);
        }

        while (carryOn) {
            if (numberOfOrders == 9) {
                carryOn = false;
            }

            if ((numberOfOrders < 10) && (!orderQueue.isEmpty())) {
                // passing in 'this' will let me see which thread is waiting.
                order = orderQueue.pullOrder(this);
                // TODO:  remove these debug lines.
                System.out.println("\tpullOrder: " + order.printNumber() + " - " + this.getName());
                System.out.println("\t" + order.printNumber() + " processed by " + this.getName());
            } else {
                return;
            }

            try {
                Thread.sleep(2000);
                sleepCount++;
                System.out.println("Sleeping - " + this.getName() + " - " + sleepCount);
            } catch (InterruptedException e) {
                System.out.println("Error in OrderHandler.run");
            }

        }
        System.out.println("\tafter while loop in OrderHandler.run() - " + this.getName());
    }

    public void stopRunning() {
        running = false;
    }

    public static synchronized int getNumberOfOrders() {
        return numberOfOrders;
    }
}
