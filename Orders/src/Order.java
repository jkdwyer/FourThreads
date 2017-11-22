public class Order {
    private int number;

    public Order (int number) {
        this.number = number;
    }

    public String printNumber() {
        Integer num = number;
        return num.toString();
    }
}
