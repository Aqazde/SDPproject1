package Cart;

import Menu.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static Cart instance;
    private final List<MenuItem> items;

    private Cart() {
        items = new ArrayList<>();
    }

    public static Cart getInstance() {
        if (instance == null) {
            synchronized (Cart.class) {
                if (instance == null) {
                    instance = new Cart();
                }
            }
        }
        return instance;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (MenuItem item : items) {
            totalCost += item.getPrice();
        }
        return totalCost;
    }
}
