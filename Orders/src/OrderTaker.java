public class OrderTaker extends Thread {
    private static int orderNumber = 1;
    private int count = 0;
    private int maxOrders;
    private OrderQueue orderQueue;

    public OrderTaker(int orderCount, OrderQueue orderQueue) {
        this.maxOrders = orderCount;
        this.orderQueue = orderQueue;
    }

    public void run() {
        Order order;
        while (count < maxOrders) {
            order = new Order(getOrderNumber());
            System.out.println("\t" + order.printNumber() + " created by " + this.getName());
            orderQueue.pushOrder(order);
            System.out.println("\tpushOrder: " + order.printNumber() + " - " + this.getName());
            count++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("error in OrderTaker.run");
            }
        }
        System.out.println("\tafter while loop in OrderTaker.run() - " + this.getName());
    }

    private static synchronized int getOrderNumber() {
        int orderNum = orderNumber++;
        System.out.println("\tin getOrderNumber: " + orderNum);
        return orderNum;
    }
}
