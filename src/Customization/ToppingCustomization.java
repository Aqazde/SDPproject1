package Customization;
import Menu.MenuItem;
public class ToppingCustomization implements CustomizationStrategy{
    private String topping;

    public ToppingCustomization(String topping) {
        this.topping = topping;
    }

    @Override
    public void customize(MenuItem menuItem) {
        System.out.println("Adding " + topping + " to " + menuItem.getName());
    }
}
