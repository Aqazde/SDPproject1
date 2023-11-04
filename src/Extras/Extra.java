package Extras;
import Menu.MenuItem;
import Payment.PaymentProcessor;
public abstract class Extra implements MenuItem{
    protected MenuItem menuItem;

    public Extra(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public String getName() {
        return menuItem.getName() + ", " + getExtraName();
    }

    @Override
    public double getPrice() {
        return menuItem.getPrice() + getExtraPrice();
    }

    protected abstract String getExtraName();
    protected abstract double getExtraPrice();
    @Override
    public void processPayment(PaymentProcessor paymentProcessor) {
        menuItem.processPayment(paymentProcessor);
        double price = getPrice();
        paymentProcessor.processPayment(price);
    }
}
