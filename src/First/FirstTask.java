package First;

import java.util.Arrays;

import static java.lang.Math.*;

public class FirstTask {
    public static void main(String[] args) {

        System.out.println("-------------------------");
        System.out.println("Вариант 1, задача 9");
        System.out.println("Условие:");
        System.out.println("Определить класс Квадратное уравнение.\n Класс должен содержать несколько конструкторов.\n Реализовать методы для поиска корней, экстремумов, а также интервалов убывания/возрастания.\n Создать массив объектов и определить наибольшие и наименьшие по значению корни.");
        System.out.println("-------------------------\n");

        QuadraticEquation quadraticEquation = new QuadraticEquation(1, -23, 120);
        double[] korny = quadraticEquation.getRoots();
        System.out.println("Вывод корней уравнения (" + quadraticEquation.getA() +"x^2)+("+ quadraticEquation.getB() +"x)+(" + quadraticEquation.getC() + "c)" +":");
        for (int i = 0; i < Arrays.stream(korny).count(); i++) {
            System.out.println(korny[i]);
        }
        quadraticEquation.getVertex();
        quadraticEquation.findIntervals();

        QuadraticEquation[] equations = new QuadraticEquation[]{
                new QuadraticEquation(1, 4, 3),
                new QuadraticEquation(1, -23, 120),
                new QuadraticEquation(3, 7, -10)
        };

        quadraticEquation.findMinMax(equations);


        System.out.println("-------------------------");
        System.out.println("Вариант 1, задача 10");
        System.out.println("Условие:");
        System.out.println("Определить класс Булева матрица (BoolMatrix) размерности (n x m).\n Класс должен содержать несколько конструкторов.\n Реализовать методы для логического сложения (дизъюнкции), умножения и инверсии матриц.\n Реализовать методы для подсчета числа единиц в матрице и упорядочения строк в лексикографическом порядке.");
        System.out.println("-------------------------\n");

        boolean[][] values = {{true, false, true}, {false, true, false}};
        boolean[][] values22 = {{true, true, true}, {false, false, false}};
        boolean[][] values2 = {{true, true}, {false, false}, {true, false}};

        BoolMatrix matrix = new BoolMatrix(values);
        BoolMatrix matrix2_test = new BoolMatrix(values22);
        BoolMatrix matrix3_test = new BoolMatrix(values2);

        System.out.println("Матрицы для сложения:");
        System.out.println("-------------------------");
        printMatrix(matrix);
        System.out.println("-------------------------");
        printMatrix(matrix2_test);
        BoolMatrix matrix2 = new BoolMatrix(values22);
        BoolMatrix sum = matrix.add(matrix2);
        System.out.println("-------------------------");
        System.out.println("Сумма матриц:");
        printMatrix(sum);

        System.out.println("Матрицы для умножения:");
        System.out.println("-------------------------");
        printMatrix(matrix);
        System.out.println("-------------------------");
        printMatrix(matrix3_test);
        System.out.println("-------------------------");
        BoolMatrix matrix3 = new BoolMatrix(values2);
        BoolMatrix product = matrix.mul(matrix3);
        System.out.println("Произведение матриц:");
        printMatrix(product);

        System.out.println("Матрицы для инверсии:");
        System.out.println("-------------------------");
        printMatrix(matrix);
        System.out.println("-------------------------");
        BoolMatrix negated = matrix.neg();
        System.out.println("Инверсия матрицы:");
        printMatrix(negated);

        System.out.println("Матрицы для подсчета единиц:");
        System.out.println("-------------------------");
        printMatrix(matrix);
        System.out.println("-------------------------");
        int count = matrix.countOnes();
        System.out.println("Количество единиц в матрице: " + count);

        System.out.println("Матрица для сортировки:");
        System.out.println("-------------------------");
        printMatrix(matrix);
        System.out.println("-------------------------");
        matrix.sortLexico();
        System.out.println("Сортировка матрицы в лексикографическом порядке:");
        printMatrix(matrix);
    }

    public static void printMatrix(BoolMatrix matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                System.out.print(matrix.getMatrix()[i][j] + " ");
            }
            System.out.println();
        }


    }
}

