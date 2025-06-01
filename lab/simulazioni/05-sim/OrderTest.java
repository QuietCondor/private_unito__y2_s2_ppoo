public class OrderTest {
    public static void main(String[] args) {
        Order ord1 = new Order("alice@example.com", 99.99);
        Order ord2 = new Order("bob@example.com", 150.00);
        Order ord3 = new Order();

        System.out.println("Ord1: " + ord1);
        System.out.println("Ord2: " + ord2);
        System.out.println("Ord3: " + ord3);

        System.out.println("Ord1 equals Ord2: " + ord1.equals(ord2));
        System.out.println("Ord1 equals Ord1: " + ord1.equals(ord1));

        ord1.applyDiscount(10); // 10% discount
        System.out.println("Ord1 after discount: " + ord1);

        System.out.println("Total orders created: " + Order.getTotalOrders());

        ExpressOrder express = new ExpressOrder("carla@example.com", 120.00, 24);
        System.out.println("ExpressOrder: " + express);
    }
}