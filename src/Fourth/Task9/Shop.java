package Fourth.Task9;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Shop {
    private Map<Integer, Product> products;
    private List<Order> orders;
    private Blacklist blacklist;

    public Shop() {
        this.products = new HashMap<>();
        this.orders = new ArrayList<>();
        this.blacklist = new Blacklist();
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    void addEmail(String email) {
        blacklist.addEmail(email);
    }

    void removeEmail(String email) {
        blacklist.removeEmail(email);
    }
    public void placeOrder(Order order) {
        if (blacklist.isBlacklisted(order.getCustomerEmail())) {
            throw new RuntimeException("Пользователь в черном списке");
        }
        orders.add(order);
    }

    public void processOrder(int orderId) {
        Order order = orders.get(orderId);
        order.setStatus(OrderStatus.PROCESSED);
    }

    public void shipOrder(int orderId) {
        Order order = orders.get(orderId);
        order.setStatus(OrderStatus.SHIPPED);
    }

    public void deliverOrder(int orderId) {
        Order order = orders.get(orderId);
        order.setStatus(OrderStatus.DELIVERED);
    }
}