package Second;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Car {
    int position;
    int speed;

    Car(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }
}

public class RaceTrack {
    public static int countPasses(List<Car> cars) {
        int passes = 0;
        Comparator<Car> speedComparator = Comparator.comparingInt(car -> car.position);
        Collections.sort(cars, speedComparator);

        for (int i = 0; i < cars.size(); i++) {
            for (int j = cars.get(i).position; j != 1; j--) {
                if (j != 1) {
                    if (cars.get(j - 2).position < cars.get(j-1).position && cars.get(j - 2).speed < cars.get(j-1).speed) {
                        passes++;
                        cars.get(j-1).position--;
                        cars.get(j - 2).position++;
                        Collections.sort(cars, speedComparator);
                    }
                }
            }
        }

        return passes;
    }
}