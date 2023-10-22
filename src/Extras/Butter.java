package Extras;
import Menu.MenuItem;
import Payment.PaymentProcessor;
public class Butter extends Extra{
    public Butter(MenuItem menuItem) {
        super(menuItem);
    }

    @Override
    protected String getExtraName() {
        return "Butter";
    }
    @Override
    protected double getExtraPrice() {
        return 0.25;
    }
    @Override
    public void processPayment(PaymentProcessor paymentProcessor) {
        double price = getPrice();
        paymentProcessor.processPayment(price);
    }
}
