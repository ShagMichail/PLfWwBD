package Fourth.Task9;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String password;
    private List<Order> orders;

    public Customer(int id,String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.orders = new ArrayList<>();
    }
    public void placeOrder(Shop shop, List<Product> products, double totalPrice) {
        Order order = new Order(0, name, email, products, totalPrice, OrderStatus.PENDING);
        shop.placeOrder(order);
        orders.add(order);
    }
    public List<Order> getOrders() {
        return orders;
    }
}
