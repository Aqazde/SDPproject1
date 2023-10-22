package User;

import java.time.LocalDateTime;
import java.util.List;
import Menu.MenuItem;

public class Order {
    private final int orderId;
    private final LocalDateTime orderDate;
    private final List<MenuItem> orderedItems;
    private final double totalCost;

    public Order(int orderId, List<MenuItem> orderedItems, double totalCost) {
        this.orderId = orderId;
        this.orderDate = LocalDateTime.now();
        this.orderedItems = List.copyOf(orderedItems);
        this.totalCost = totalCost;
    }

    public int getOrderId() {
        return orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public List<MenuItem> getOrderedItems() {
        return orderedItems;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
