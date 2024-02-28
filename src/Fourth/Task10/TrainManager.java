package Fourth.Task10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TrainManager {

    private Boolean flag = false;
    private List<Train> trains;

    private List<Ticket> tikets;

    public TrainManager() {
        this.trains = new ArrayList<>();
        this.tikets = new ArrayList<>();
    }

    public Train findTrain(String data, String time, String station) {
        for (Train train : trains) {
            List<Station> rout = train.getRoute();
            for (Station stationF : rout) {
                if (stationF.getName() == station) {

                    String date1 = data;
                    String date2 = stationF.getDate();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

                    LocalDate date1LocalDate = LocalDate.parse(date1, formatter);
                    LocalDate date2LocalDate = LocalDate.parse(date2, formatter);

                    if (date1LocalDate.isBefore(date2LocalDate) || date1LocalDate.isEqual(date2LocalDate)) {
                        LocalDate date = date2LocalDate;

                        if (date.isEqual(date1LocalDate)) {
                            String inputF = time;
                            String[] linesF = inputF.split(":");
                            String inputS = stationF.getArrivalTime();
                            String[] linesS = inputS.split(":");
                            if ((Integer.parseInt(linesF[0])) < (Integer.parseInt(linesS[0]))) {
                                flag = true;
                            } else if (((Integer.parseInt(linesF[0])) == (Integer.parseInt(linesS[0])))) {
                                if (Integer.parseInt(linesF[1]) <= Integer.parseInt(linesS[1])) {
                                    flag = true;
                                }
                            }
                            if (flag) {
                                System.out.println("Доступен поезд: " + train.getNumber() +
                                        "\n Время отправление со станции " + stationF.getName() + " в " + stationF.getArrivalTime() +
                                        "\nДата отправления: " + stationF.getDate());
                            }
                        } else if (!date.isBefore(date1LocalDate)) {
                            System.out.println("Доступен поезд: " + train.getNumber() +
                                    "\n Время отправление со станции " + stationF.getName() + " в " + stationF.getArrivalTime() +
                                    "\nДата отправления: " + stationF.getDate());
                        }
                    }
                }
            }
        }
        return null;
    }

    public void selectionTrain(int trainNumber, Passenger passenger) {
        for (Train train : trains) {
            if (train.getNumber() == trainNumber) {
                Ticket tiket = new Ticket(passenger, train.getPrice());
                tikets.add(tiket);
                System.out.println("Оформлен новый билет\n на пассажира: " + passenger.getName() +
                        "\n на поезд:  " + train.getNumber());
            }

        }
    }

    public void addTrains(Train train) {
        trains.add(train);
    }

}