public class CashPayment implements PaymentMethod {
    @Override
    public double calculatePaymentFee(double subtotal, double deliveryCost) {
        return subtotal + deliveryCost;
    }
}
