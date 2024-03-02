package Second;

import java.util.ArrayList;
import java.util.Stack;

import static Second.MaxIdenticalSubmatrix.findLargestSubmatrix;
import static Second.RaceTrack.countPasses;

public class SecondTask {
    public static void main(String[] args) {

        System.out.println("-------------------------");
        System.out.println("Вариант 2, задача 9");
        System.out.println("Условие:");
        System.out.println("Дана матрица из целых чисел. \nНайти в ней прямоугольную подматрицу, состоящую из максимального количества одинаковых элементов. \nИспользовать класс Stack.");
        System.out.println("-------------------------\n");

        int[][] matrix = {
                {1, 2, 3, 4},
                {4, 4, 4, 4},
                {3, 3, 3, 3},
                {2, 2, 2, 2}
        };

        MaxIdenticalSubmatrix.MatrixElement result = findLargestSubmatrix(matrix);

        System.out.println("-------------------------");
        System.out.println("Вариант 2, задача 10");
        System.out.println("Условие:");
        System.out.println("На прямой гоночной трассе стоит N автомобилей, для каждого из которых известны начальное положение и скорость. \nОпределить, сколько произойдет обгонов.");
        System.out.println("-------------------------\n");

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car(4, 260));
        cars.add(new Car(2, 230));
        cars.add(new Car(3, 240));
        cars.add(new Car(1, 220));
        System.out.println("Number of passes: " + countPasses(cars));
    }
}