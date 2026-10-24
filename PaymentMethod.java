public interface PaymentMethod {
    double calculatePaymentFee(double subtotal, double deliveryCost);
}
