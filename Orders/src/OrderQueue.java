import java.util.LinkedList;

public class OrderQueue {
    private int count = 0;
    private LinkedList<Order> orderQueue = new LinkedList<Order>();

    public synchronized void pushOrder(Order order) {
        orderQueue.addLast(order);
        notifyAll();
    }

    public synchronized Order pullOrder(OrderHandler oh) {
        while (orderQueue.size() == 0) {
            try {
                System.out.println("Wait - " + oh.getName());
                wait();
            } catch (InterruptedException e) {
                System.out.println("Error in OrderQueue.pullOrder");
            }
        }
        return orderQueue.removeFirst();
    }

    public boolean isEmpty() {
        return (orderQueue.size() == 0);
    }
}
