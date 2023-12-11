package Observer;

import Menu.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class ManagerObserver {
    private List<OrderObserver> observers;

    public ManagerObserver() {
        observers = new ArrayList<>();
    }

    public void registerObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(int orderId, List<MenuItem> orderedItems, double totalCost) {
        for (OrderObserver observer : observers) {
            observer.update(orderId, orderedItems, totalCost);
        }
    }
}
