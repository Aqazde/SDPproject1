package Menu.factories;
import Menu.*;

public class MenuItemFactory {
    public MenuItem createMenuItem(String type) {
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
