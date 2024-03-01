package Second.Task9;

public abstract class Furniture {
    private String manufacturer;
    private String color;

    public Furniture(String manufacturer, String color) {
        this.manufacturer = manufacturer;
        this.color = color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getColor() {
        return color;
    }

    public abstract double getArea();
}

