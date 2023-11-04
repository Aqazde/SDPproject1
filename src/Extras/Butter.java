package Extras;
import Menu.MenuItem;
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
}
