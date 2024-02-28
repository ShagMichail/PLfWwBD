package First;

import java.util.Arrays;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    QuadraticEquation() {

    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public QuadraticEquation(double a, double b) {
        this(a, b, 0);
    }

    public QuadraticEquation(double a) {
        this(a, 0, 0);
    }

    public double getA() {
        return this.a;
    }
    public double getB() {
        return this.b;
    }
    public double getC() {
        return this.c;
    }
    // проверка на наличие корней
    public double getDet() {
        return pow(b, 2) - (4 * a * c);
    }  //возводим в степень

    //метод для поиска корней
    public double[] getRoots() {
        double discriminant = b * b - 4 * a * c;
        double sqrtDiscriminant = Math.sqrt(Math.abs(discriminant));

        if (discriminant > 0) {
            return new double[] {
                    (-b + sqrtDiscriminant) / (2 * a),
                    (-b - sqrtDiscriminant) / (2 * a)
            };
        } else if (discriminant == 0) {
            return new double[] { -b / (2 * a) };
        } else {
            return new double[0];
        }
    }

    // находим вершину параболы
    public void getVertex() {
        double xv = -b / (2 * a);
        double yv = a * xv * xv + b * xv + c;
        System.out.println("Координаты вершины параболы:\nx = " + xv +"\ny = " + yv);
//        return new double[] { xv, yv };
    }

    // находим максимальный и минимальный корень
    public void findIntervals() {
        if (a > 0) {
            System.out.println("Уменьшается в интервале (-∞, " + -b / (2 * a) + ") и увеличивается в интервале (" + -b / (2 * a) + ", ∞)");
        } else if (a < 0) {
            System.out.println("Увеличивается в интервале (-∞, " + -b / (2 * a) + ") и уменьшается в интервале (" + -b / (2 * a) + ", ∞)");
        } else {
            System.out.println("Константная функция");
        }
    }

    public void findMinMax(QuadraticEquation[] array) {
        double minKoren = 0;
        double maxKoren = 0;
        double[] kornyProm = array[0].getRoots();

        if (Arrays.stream(kornyProm).count() == 2) {
            double x1 = kornyProm[0];
            double x2 = kornyProm[1];
            if (kornyProm[0] > kornyProm[1]) {
                minKoren = kornyProm[1];
                maxKoren = kornyProm[0];
            } else {
                minKoren = kornyProm[0];
                maxKoren = kornyProm[1];
            }
        }

        for (int i = 1; i < Arrays.stream(array).count(); i++) {
            kornyProm = array[i].getRoots();
            for (int j = 0; j < Arrays.stream(kornyProm).count(); j++) {
                if (kornyProm[j] < minKoren) {
                    minKoren = kornyProm[j];
                } else if (kornyProm[j] > maxKoren) {
                    maxKoren = kornyProm[j];
                }
            }
        }
        System.out.println("Вывод максимального и минимального корней уравнений:");
        System.out.println("minKoren: " + minKoren);
        System.out.println("maxKoren: " + maxKoren);
    }
}
