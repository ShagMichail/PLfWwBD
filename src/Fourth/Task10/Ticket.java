package Fourth.Task10;

import java.time.LocalDateTime;
public class Ticket {
    private Passenger passenger;
    private double price;

    public Ticket(Passenger passenger, double price) {
        this.passenger = passenger;
        this.price = price;
    }
}
