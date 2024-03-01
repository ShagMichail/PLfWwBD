package Second.Task9;

public class Bookcase extends Cabinet {
    private int numberOfShelves;

    public Bookcase(String manufacturer, String color, int numberOfDoors, int numberOfShelves) {
        super(manufacturer, color, numberOfDoors);
        this.numberOfShelves = numberOfShelves;
    }

    public int getNumberOfShelves() {
        return numberOfShelves;
    }

    public double getArea() {
        return numberOfShelves;
    }

    public double getVolume() {
        return numberOfShelves * 0.5;
    }
}
