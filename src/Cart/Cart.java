package Cart;

import Observer.OrderObserver;
import Observer.OrderSubject;
import Menu.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Cart implements OrderSubject {
    private static Cart instance;
    private List<MenuItem> items;
    private List<OrderObserver> observers;

    private Cart() {
        items = new ArrayList<>();
        observers = new ArrayList<>();
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

    @Override
    public void registerObserver(OrderObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(getNextOrderId(), items, getTotalCost());
        }
    }

    private int getNextOrderId() {
        return 0;
    }
}
