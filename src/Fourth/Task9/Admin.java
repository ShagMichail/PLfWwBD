package Fourth.Task9;

public class Admin {
    private String username;
    private String password;
    private Shop shop;

    public Admin(String username, String password, Shop shop) {
        this.username = username;
        this.password = password;
        this.shop = shop;
    }

    public void addProduct(Product product) {
        shop.addProduct(product);
    }
    public void processOrder(int orderId) {
        shop.processOrder(orderId);
    }

    public void shipOrder(int orderId) {
        shop.shipOrder(orderId);
    }

    public void deliverOrder(int orderId) {
        shop.deliverOrder(orderId);
    }

    public void addEmailCustomer(String email) {
        shop.addEmail(email);
    }
}