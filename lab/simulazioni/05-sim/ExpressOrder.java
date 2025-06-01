public class ExpressOrder extends Order {
    private int _deliveryHours;

    public ExpressOrder(int deliveryHours) {
        super();
        _deliveryHours = deliveryHours;
    }

    public ExpressOrder(String customerEmail, double orderTotal, int deliveryHours) {
        super(customerEmail, orderTotal);
        _deliveryHours = deliveryHours;
    }

    @Override
    public String toString() {
        String base = super.toString();

        return String.format("%s - [Del. Hours = %s]", base, _deliveryHours);
    }
}
