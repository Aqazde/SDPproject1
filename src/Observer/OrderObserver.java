package Observer;

import Menu.MenuItem;

import java.util.List;

public interface OrderObserver {
    void update(int orderId, List<MenuItem> orderedItems, double totalCost);
}
