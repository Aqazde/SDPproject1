package User;
import java.util.Date;
import java.util.List;
import Menu.MenuItem;
public class Order {
    private int orderId;
    private Date orderDate;
    private List<MenuItem> orderedItems;
    private double totalCost;

    public Order(int orderId, List<MenuItem> orderedItems, double totalCost) {
        this.orderId = orderId;
        this.orderDate = new Date();
        this.orderedItems = orderedItems;
        this.totalCost = totalCost;
    }
    public int getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public List<MenuItem> getOrderedItems() {
        return orderedItems;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
