package Menu.Lunch;

import Menu.MenuItem;
import Payment.PaymentProcessor;

public abstract class LunchItem implements MenuItem {
    private final String name;
    private final double basePrice;

    public LunchItem(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return basePrice;
    }

    @Override
    public void processPayment(PaymentProcessor paymentProcessor) {
        double price = getPrice();
        paymentProcessor.processPayment(price);
    }
}
