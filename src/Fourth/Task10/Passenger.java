package Fourth.Task10;

public class Passenger {
    private String name;
    private String email;
    private String password;

    private TrainManager trainManager;

    public Passenger(String name, String email, String password, TrainManager trainManager) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.trainManager = trainManager;
    }

    public String getName() {
        return name;
    }
    public void findTrains(String data, String time, String station) {
        trainManager.findTrain(data, time, station);
    }

    public void selectionTrain(int train) {
        trainManager.selectionTrain(train, this);
    }

}
