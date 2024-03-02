package First;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstTask {
    public static void main(String[] args) {

        System.out.println("-------------------------");
        System.out.println("Вариант 1, задача 1");
        System.out.println("Условие:");
        System.out.println("Определить множество на основе множества целых чисел. \nСоздать методы для определения пересечения и объединения множеств.");
        System.out.println("-------------------------\n");

        IntegerSet set1 = new IntegerSet(1, 2, 3, 4, 5);
        IntegerSet set2 = new IntegerSet(4, 5, 6, 7, 8);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);

        IntegerSet intersection = set1.intersect(set2);
        System.out.println("Пересечения множеств: " + intersection);

        IntegerSet union = set1.union(set2);
        System.out.println("Объединение множеств: " + union);

        System.out.println("-------------------------");
        System.out.println("Вариант 1, задача 2");
        System.out.println("Условие:");
        System.out.println("Списки (стеки, очереди) I(1..n) и U(1..n) содержат результаты n измерений тока и напряжения на неизвестном сопротивлении R. \nНайти приближенное число R методом наименьших квадратов. \n");
        System.out.println("-------------------------\n");

        List<Double> currents = Arrays.asList(0.001, 0.002, 0.003);
        List<Double> voltages = Arrays.asList(0.002, 0.005, 0.0066);

        double[] coefficients = calculateLeastSquares(currents, voltages);

        System.out.println("Приближенное значение сопротивления: " + coefficients[1]);
    }

    public static double[] calculateLeastSquares(List<Double> currents, List<Double> voltages) {
        if (currents.size() != voltages.size()) {
            throw new IllegalArgumentException("Currents and voltages lists must have the same size.");
        }

        int n = currents.size();

        double sumCurrent = 0;
        double sumVoltage = 0;
        double sumCurrentSquared = 0;
        double sumCurrentVoltage = 0;

        for (int i = 0; i < n; i++) {
            sumCurrent += currents.get(i);
            sumVoltage += voltages.get(i);
            sumCurrentSquared += currents.get(i) * currents.get(i);
            sumCurrentVoltage += currents.get(i) * voltages.get(i);
        }

        double[] coefficients = new double[2];

        double denominator = n * sumCurrentSquared - sumCurrent * sumCurrent;

        if (denominator == 0) {
            throw new ArithmeticException("Нельзя делить на 0");
        }

        coefficients[0] = (sumVoltage * sumCurrentSquared - sumCurrent * sumCurrentVoltage) / denominator;
        coefficients[1] = (n * sumCurrentVoltage - sumCurrent * sumVoltage) / denominator;

        return coefficients;
    }
}