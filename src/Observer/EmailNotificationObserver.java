package Observer;

import Menu.MenuItem;

import java.util.List;

public class EmailNotificationObserver implements OrderObserver {
    @Override
    public void update(int orderId, List<MenuItem> orderedItems, double totalCost) {
        System.out.println("\n Email Notification");
        System.out.println("Order ID: "+ orderId);
        System.out.println("Ordered Items:");
        for (MenuItem item : orderedItems) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total Cost: $" + totalCost);
    }
}
