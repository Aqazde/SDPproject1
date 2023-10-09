package Extras;
import Menu.MenuItem;
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
}
