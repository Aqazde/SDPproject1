package Customization;
import Menu.MenuItem;
public class BeverageCustomization implements CustomizationStrategy{
    private String beverage;

    public BeverageCustomization(String beverage) {
        this.beverage = beverage;
    }

    @Override
    public void customize(MenuItem menuItem) {
        System.out.println("Adding " + beverage + " to " + menuItem.getName());
    }
}
