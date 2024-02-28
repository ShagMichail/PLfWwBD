package First;

import java.util.Arrays;

public class BoolMatrix {
    private boolean[][] matrix;
    private int rows;
    private int cols;

    // Конструктор нулевой матрицы размера n x m
    public BoolMatrix(int n, int m) {
        matrix = new boolean[n][m];
        rows = n;
        cols = m;
    }

    // Конструктор матрицы, инициализированной логическими значениями.
    public BoolMatrix(boolean[][] values) {
        matrix = values;
        rows = values.length;
        cols = values[0].length;
    }

    // Логическая сумма (дизъюнкция) двух матриц
    public BoolMatrix add(BoolMatrix other) {
        if (rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException("Матрицы имеют разные размерности!");
        }
        boolean[][] result = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] || other.matrix[i][j];
            }
        }
        return new BoolMatrix(result);
    }

    // Умножение двух матриц
    public BoolMatrix mul(BoolMatrix other) {
        if (cols != other.rows) {
            throw new IllegalArgumentException("Матрицы имеют несовместимые размеры!");
        }
        boolean[][] result = new boolean[rows][other.cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < cols; k++) {
                    result[i][j] = result[i][j] || (matrix[i][k] && other.matrix[k][j]);
                }
            }
        }
        return new BoolMatrix(result);
    }

    // Логическое отрицание (инверсия) матрицы
    public BoolMatrix neg() {
        boolean[][] result = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = !matrix[i][j];
            }
        }
        return new BoolMatrix(result);
    }

    // Посчитайте количество единиц в матрице
    public int countOnes() {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Отсортируйте строки матрицы в лексикографическом порядке.
    public void sortLexico() {
        Row[] rowsArray = new Row[rows];
        for (int i = 0; i < rows; i++) {
            rowsArray[i] = new Row(matrix[i]);
        }
        Arrays.sort(rowsArray);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rowsArray[i].values[j];
            }
        }
    }

    // Вложенный класс для сортировки строк
    private static class Row implements Comparable<Row> {
        boolean[] values;
        public Row(boolean[] v) {
            values = v;
        }
        public int compareTo(Row other) {
            for (int i = 0; i < values.length; i++) {
                if (values[i] != other.values[i]) {
                    return Boolean.compare(values[i], other.values[i]);
                }
            }
            return 0;
        }
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public boolean[][] getMatrix() {
        return this.matrix;
    }

}