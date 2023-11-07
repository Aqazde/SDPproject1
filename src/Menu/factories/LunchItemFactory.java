package Menu.factories;

import Menu.Lunch.LunchItem;
import Menu.Lunch.Salad;
import Menu.Lunch.Pasta;

public class LunchItemFactory {
    public LunchItem createLunchItem(String type) {
        if (type.equalsIgnoreCase("Salad")) {
            return new Salad();
        } else if (type.equalsIgnoreCase("Pasta")) {
            return new Pasta();
        } else {
            return null;
        }
    }
}
