package Fourth.Task10;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Station {
    private String name;
    private String arrivalTime;
    private String date;

    public Station(String name, String arrivalTime, String date) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.date = date;
//        this.trains = trains;
    }

    public String getName() {
        return name;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDate() {
        return date;
    }

//    public boolean canArriveAt(LocalDateTime time) {
//        LocalDateTime arrivalTime = getArrivalTime();
//        return !arrivalTime.isAfter(time) && time.isAfter(getDepartureTime());
//    }

//    private LocalDateTime getDepartureTime() {
//        // Здесь необходимо реализовать получение времени отправления поезда со станции
//
//    }
//
//    private LocalDateTime getArrivalTime() {
//        // Здесь необходимо реализовать получение времени прибытия поезда на станцию
//    }
//
//    public int getTravelTime() {
//        // Здесь необходимо реализовать получение времени в минутах, необходимого для путешествия до следующей станции
//    }

    // Остальные методы класса Station
}
