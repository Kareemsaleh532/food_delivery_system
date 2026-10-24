import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        System.out.println("--- Food Delivery System Test ---");

        MenuItem burgerMeal = new Meal("Burger Meal", 8.0, 1);
        MenuItem largeJuice = new Drink("Large Juice", 3.0, true);

        Order order = new Order("Ahmad", new ExpressDelivery());

        order.addItem(burgerMeal, 2);
        order.addItem(largeJuice, 1);

        System.out.printf(Locale.US, "Subtotal: $%.2f%n", order.calculateSubtotal());
        System.out.printf(Locale.US, "Total (with Express Delivery): $%.2f%n", order.calculateTotal());

        PaymentMethod paymentMethod = new CardPayment();
        double finalAmount = order.pay(paymentMethod);

        if (finalAmount > 0) {
            System.out.printf(Locale.US, "Paid successfully: $%.2f%n", finalAmount);
        }

        order.deliver();
    }
}
