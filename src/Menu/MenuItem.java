package Menu;
import Payment.PaymentProcessor;
public interface MenuItem {
    String getName();
    double getPrice();
    void processPayment(PaymentProcessor paymentProcessor);
}
