import Cart.*;
import Customization.*;
import Extras.*;
import Menu.*;
import Menu.Breakfast.*;
import Menu.factories.*;
import User.*;
import Payment.*;
import Observer.*;
import java.util.List;
public class Client {
    public static void main(String[] args) {
        // Create the item factories
        MenuItemFactory menuItemFactory = new MenuItemFactory();
        BreakfastItemFactory breakfastItemFactory = new BreakfastItemFactory();
        LunchItemFactory lunchItemFactory = new LunchItemFactory();

        MenuItem omelette = menuItemFactory.createMenuItem("Omelette");
        MenuItem pancakes = menuItemFactory.createMenuItem("Pancakes");

        // Create Breakfast items using the BreakfastItemFactory
        BreakfastItem cereal = breakfastItemFactory.createBreakfastItem("Cereal");

        // Customize the Breakfast items
        CustomizationStrategy toppingCustomization = new ToppingCustomization("Cheese");
        CustomizationStrategy beverageCustomization = new BeverageCustomization("Coffee");
        toppingCustomization.customize(omelette);
        beverageCustomization.customize(pancakes);

        // Create customized items with Extras
        MenuItem pancakesWithSyrup = new Syrup(pancakes);
        MenuItem omeletteWithButter = new Butter(pancakesWithSyrup);

        // Create Lunch items
        MenuItem salad = lunchItemFactory.createLunchItem("Salad");
        MenuItem pasta = lunchItemFactory.createLunchItem("Pasta");

        // Customize the Lunch items
        CustomizationStrategy lunchCustomization = new ToppingCustomization("Tomatoes");
        lunchCustomization.customize(salad);

        // Create a shopping cart
        Cart cart = Cart.getInstance();
        cart.addItem(pancakesWithSyrup);
        cart.addItem(omeletteWithButter);
        cart.addItem(salad);
        cart.addItem(pasta);
        // Process payments for items in the cart
        PaymentProcessor paymentProcessor = new PaymentGatewayAdapter(new Payment.PaymentGateway());
        for (MenuItem item : cart.getItems()) {
            item.processPayment(paymentProcessor);
        }

        // Create and register observers
        ManagerObserver managerObserver = new ManagerObserver();
        EmailNotificationObserver emailObserver = new EmailNotificationObserver();
        SMSNotificationObserver smsObserver = new SMSNotificationObserver();

        managerObserver.registerObserver(emailObserver);
        managerObserver.registerObserver(smsObserver);

        // Notify observers
        List<MenuItem> cartItems = cart.getItems();
        double totalCost = cart.getTotalCost();
        managerObserver.notifyObservers(1, cartItems, totalCost);

        // Place the order
        System.out.println("Items in the Cart:");
        for (MenuItem item : cart.getItems()) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total Cost: $" + totalCost);

        User user = new User("example", "123");
        Order order = new Order(1, cart.getItems(), totalCost);
        user.addOrderToHistory(order);

        System.out.println("Order History for " + user.getUsername() + ":");
        for (Order userOrder : user.getOrderHistory()) {
            System.out.println("Order ID: " + userOrder.getOrderId());
            System.out.println("Order Date: " + userOrder.getOrderDate());
            System.out.println("Total Cost: $" + userOrder.getTotalCost());
            System.out.println("Ordered Items:");
            for (MenuItem item : userOrder.getOrderedItems()) {
                System.out.println(item.getName() + " - $" + item.getPrice());
            }
            System.out.println();
        }
    }
}
