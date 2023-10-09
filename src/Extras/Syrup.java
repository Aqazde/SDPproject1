package Extras;
import Menu.MenuItem;
public class Syrup extends Extra{
    public Syrup(MenuItem menuItem) {
        super(menuItem);
    }

    @Override
    protected String getExtraName() {
        return "Syrup";
    }

    @Override
    protected double getExtraPrice() {
        return 0.25;
    }
}
