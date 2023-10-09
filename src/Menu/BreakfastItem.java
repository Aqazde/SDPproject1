package Menu;

public abstract class BreakfastItem implements MenuItem{
    private String name;
    private double basePrice;

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
}
