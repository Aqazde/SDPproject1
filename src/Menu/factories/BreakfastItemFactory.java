package Menu.factories;

import Menu.BreakfastItem;
import Menu.Cereal;
import Menu.Omelette;
import Menu.Pancakes;

public class BreakfastItemFactory {
    public BreakfastItem createBreakfastItem(String type) {
        if (type.equalsIgnoreCase("Cereal")) {
            return new Cereal();
        } else if (type.equalsIgnoreCase("Omelette")) {
            return new Omelette();
        } else if (type.equalsIgnoreCase("Pancakes")) {
            return new Pancakes();
        } else {
            return null;
        }
    }
}
