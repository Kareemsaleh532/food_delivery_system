public class CardPayment implements PaymentMethod {
    @Override
    public double calculatePaymentFee(double subtotal, double deliveryCost) {
        double total = subtotal + deliveryCost;
        return total * 1.02;
    }
}
