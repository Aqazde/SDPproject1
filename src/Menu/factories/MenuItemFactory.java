package Menu.factories;

import Menu.*;
import Menu.Breakfast.Cereal;
import Menu.Breakfast.Omelette;
import Menu.Breakfast.Pancakes;
import Menu.Lunch.Salad;
import Menu.Lunch.Pasta;

public class MenuItemFactory {
    public MenuItem createMenuItem(String type) {
        if (type.equalsIgnoreCase("Cereal")) {
            return new Cereal();
        } else if (type.equalsIgnoreCase("Omelette")) {
            return new Omelette();
        } else if (type.equalsIgnoreCase("Pancakes")) {
            return new Pancakes();
        } else if (type.equalsIgnoreCase("Salad")) {
            return new Salad();
        } else if (type.equalsIgnoreCase("Pasta")) {
            return new Pasta();
        } else {
            return null;
        }
    }
}
