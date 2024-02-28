package Second;

public class Train {
    // Define the attributes of the Train class
    private String destination;
    private int trainNumber;
    private String departureTime;
    private int totalSeats;
    private int commonSeats;
    private int sleeperSeats;
    private int luxurySeats;

    // Constructor for Train class
    public Train(String destination, int trainNumber, String departureTime, int totalSeats, int commonSeats, int sleeperSeats, int luxurySeats) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        this.totalSeats = totalSeats;
        this.commonSeats = commonSeats;
        this.sleeperSeats = sleeperSeats;
        this.luxurySeats = luxurySeats;
    }

    // Getter methods for each attribute
    public String getDestination() {
        return destination;
    }

    public void setDestination(int String) {
        this.destination = destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setManufacturer(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getCommonSeats() {
        return commonSeats;
    }

    public void setCommonSeats(int commonSeats) {
        this.commonSeats = commonSeats;
    }

    public int getSleeperSeats() {
        return sleeperSeats;
    }

    public void setSleeperSeats(int sleeperSeats) {
        this.sleeperSeats = sleeperSeats;
    }

    public int getLuxurySeats() {
        return luxurySeats;
    }

    public void setLuxurySeats(int luxurySeats) {
        this.luxurySeats = luxurySeats;
    }

    @Override
    public String toString() {
        return "Train{" +
                "destination=" + destination +
                ", trainNumber='" + trainNumber + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", totalSeats='" + totalSeats + '\'' +
                ", commonSeats=" + commonSeats +
                ", sleeperSeats=" + sleeperSeats +
                ", luxurySeats=" + luxurySeats +
                '}';
    }
}