package Fourth.Task10;

import java.util.List;
public class Train {
    private int number;
    private Station currentStation;
    private List<Station> route;
    private double price;

    public Train(int number, Station currentStation, List<Station> route, double price) {
        this.number = number;
        this.currentStation = currentStation;
        this.route = route;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public List<Station> getRoute() {
        return route;
    }

}
