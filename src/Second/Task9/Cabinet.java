package Second.Task9;

public abstract class Cabinet extends Furniture implements FurnitureItem {
    private int numberOfDoors;

    public Cabinet(String manufacturer, String color, int numberOfDoors) {
        super(manufacturer, color);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public String getName() {
        return "Cabinet";
    }

    public abstract double getVolume();
}
