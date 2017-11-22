public class OrderQueueApp {
    public static void main (String args[]) {
        final int TAKER_CT = 3;
        final int ORDER_CT = 3;
        final int HANDLER_CT = 2;

        OrderQueue queue = new OrderQueue();

        System.out.println("Starting (" + TAKER_CT + ") order taker threads " +
            "each producing (" + ORDER_CT + ") orders and (" + HANDLER_CT +
            ") order handler threads.");

        for (int i = 0; i < TAKER_CT; i++) {
            OrderTaker t = new OrderTaker(ORDER_CT, queue);
            t.start();
            System.out.println("Starting taker (" + i + ") - " + t.getName());
        }

        for (int i = 0; i < HANDLER_CT; i++) {
            OrderHandler h = new OrderHandler(queue);
            h.start();
            System.out.println("Starting handler (" + i + ") - " + h.getName());
        }
    }
}
