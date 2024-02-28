package Fourth.Task9;

import java.util.List;

public class Order {
    private int id;
    private String customerName;
    private String customerEmail;
    private List<Product> products;
    private double totalPrice;
    private OrderStatus status;

    public Order(int id, String customerName, String customerEmail, List<Product> products, double totalPrice, OrderStatus status) {
        this.id = id;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.products = products;
        this.totalPrice = totalPrice;
        this.status = status;
    }
    public int getId() {
        return id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
