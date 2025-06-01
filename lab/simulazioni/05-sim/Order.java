public class Order {
    private static int orderCounter = 0;

    private int _orderId;
    private String _customerEmail;
    private double _orderTotal;

    public Order(String customerEmail, double orderTotal) {
        _customerEmail = customerEmail;
        _orderTotal = orderTotal;

        _orderId = orderCounter;
        orderCounter++;
    }

    public Order() {
        _orderId = orderCounter;
        orderCounter++;
    }

    public int getOrderId() {
        return this._orderId;
    }

    public String getCustomerEmail() {
        return this._customerEmail;
    }

    public double getOrderTotal() {
        return this._orderTotal;
    }

    public void getCustomerEmail(String customerEmail) {
        this._customerEmail = customerEmail;
    }

    public void getOrderTotal(double orderTotal) {
        this._orderTotal = orderTotal;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Order)) {
            return false;
        }

        Order castedObj = (Order) obj;

        return this._orderId == castedObj._orderId;
    }

    @Override
    public String toString() {
        return String.format("[ID = %s, Customer = %s, Total = %s]", this._orderId, this._customerEmail,
                this._orderTotal);
    }

    public void applyDiscount(double percentage) {
        if (percentage <= 0) {
            return;
        }

        _orderTotal = _orderTotal - (_orderTotal * percentage / 100);
    }

    public static int getTotalOrders() {
        return Order.orderCounter;
    }
}
