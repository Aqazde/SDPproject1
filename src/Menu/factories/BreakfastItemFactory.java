package Menu.factories;

import Menu.Breakfast.BreakfastItem;
import Menu.Breakfast.Cereal;
import Menu.Breakfast.Omelette;
import Menu.Breakfast.Pancakes;

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
