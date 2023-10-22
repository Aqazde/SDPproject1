import Cart.*;
import Customization.*;
import Extras.*;
import Menu.*;
import User.*;
import Payment.*;

public class Client {
    public static void main(String[] args) {
        MenuItem omelette = new Omelette();
        MenuItem pancakes = new Pancakes();

        CustomizationStrategy toppingCustomization = new ToppingCustomization("Cheese");
        CustomizationStrategy beverageCustomization = new BeverageCustomization("Coffee");
        toppingCustomization.customize(omelette);
        beverageCustomization.customize(pancakes);

        MenuItem pancakesWithSyrup = new Syrup(pancakes);
        MenuItem omeletteWithButter = new Butter(omelette);

        Cart cart = Cart.getInstance();
        cart.addItem(pancakesWithSyrup);
        cart.addItem(omeletteWithButter);


        PaymentProcessor paymentProcessor = new PaymentGatewayAdapter(new Payment.PaymentGateway());


        for (MenuItem item : cart.getItems()) {
            item.processPayment(paymentProcessor);
        }

        Cart cart1 = Cart.getInstance();
        cart1.addItem(pancakesWithSyrup);
        cart1.removeItem(omeletteWithButter);

        System.out.println("Items in the Cart:");
        for (MenuItem item : cart.getItems()) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        double totalCost = cart.getTotalCost();
        System.out.println("Total Cost: $" + totalCost);

        User user = new User("example", "123");
        Order order = new Order(1, cart.getItems(), totalCost);
        user.addOrderToHistory(order);

        System.out.println("Order History: " + user.getUsername());
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
