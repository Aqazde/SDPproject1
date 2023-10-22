package Payment;
public class PaymentGatewayAdapter implements PaymentProcessor {
    private final PaymentGateway paymentGateway;
    public PaymentGatewayAdapter(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public void processPayment(double amount) {
        paymentGateway.processPayment(amount);
    }
}
