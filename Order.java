import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Order {
    private static int nextOrderNumber = 1001;

    private final int orderNumber;
    private final String customerName;
    private final DeliveryOption deliveryOption;
    private final List<OrderLine> orderLines;
    private OrderStatus status;

    public Order(String customerName, DeliveryOption deliveryOption) {
        this.orderNumber = nextOrderNumber++;
        this.customerName = customerName;
        this.deliveryOption = deliveryOption;
        this.status = OrderStatus.NEW;
        this.orderLines = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        addItem(item, 1);
    }

    public void addItem(MenuItem item, int quantity) {
        if (!isNewOrder()) {
            System.out.println("Error: Items can only be added while the order is NEW.");
            return;
        }

        if (quantity <= 0) {
            System.out.println("Error: Quantity must be greater than zero.");
            return;
        }

        orderLines.add(new OrderLine(item, quantity));
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (OrderLine line : orderLines) {
            subtotal += line.getLineTotal();
        }
        return subtotal;
    }

    public double calculateTotal() {
        return calculateSubtotal() + deliveryOption.getDeliveryCost();
    }

    public void cancelOrder() {
        if (isNewOrder()) {
            this.status = OrderStatus.CANCELLED;
            System.out.println("Order #" + orderNumber + " has been CANCELLED.");
        } else {
            System.out.println("Error: Only a NEW order can be cancelled.");
        }
    }

    public double pay(PaymentMethod paymentMethod) {
        if (!isNewOrder()) {
            System.out.println("Error: Order cannot be paid in its current state.");
            return -1;
        }

        double finalAmount = paymentMethod.calculatePaymentFee(calculateSubtotal(), deliveryOption.getDeliveryCost());
        this.status = OrderStatus.PAID;

        System.out.printf(Locale.US, "Order #%d is now PAID. Final Amount: $%.2f%n", orderNumber, finalAmount);
        return finalAmount;
    }

    public void deliver() {
        if (this.status == OrderStatus.PAID) {
            this.status = OrderStatus.DELIVERED;
            System.out.println("Order #" + orderNumber + " has been DELIVERED successfully.");
        } else {
            System.out.println("Error: Only a PAID order can be delivered.");
        }
    }

    private boolean isNewOrder() {
        return this.status == OrderStatus.NEW;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
}
