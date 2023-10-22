package Menu;

import Payment.PaymentProcessor;

public abstract class BreakfastItem implements MenuItem {
    private final String name;
    private final double basePrice;

    public BreakfastItem(String name, double basePrice) {
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
