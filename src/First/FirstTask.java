package First;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FirstTask {
    public static void main(String[] args) {
        System.out.println("-------------------------");
        System.out.println("Вариант 1, задача 9");
        System.out.println("Условие:");
        System.out.println("В следующих заданиях требуется ввести последовательность строк из текстового потока и \nвыполнить указанные действия. При этом могут рассматриваться два варианта:");
        System.out.println("• каждая строка состоит из одного слова");
        System.out.println("• каждая строка состоит из нескольких слов");
        System.out.println("Имена входного и выходного файлов, а также абсолютный путь к ним \nмогут быть введены как параметры командной строки или храниться в файле.\n");
        System.out.println("Входной файл содержит совокупность строк. \nСтрока файла содержит строку квадратной матрицы. \nВвести матрицу в двумерный массив (размер матрицы найти). \nВывести исходную матрицу и результат ее транспонирования.");
        System.out.println("-------------------------\n");


        if (args.length != 1) {
            System.err.println("Usage: java MatrixRotator <filename>");
            System.exit(1);
        }

        String filename = args[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            try {
                int n = getMatrixDimension(reader);
                int[][] matrix = readMatrix(reader, n);
                printMatrix(matrix, "Оригинальная матрица:");
                int[][] rotatedMatrix = rotateMatrixClockwise(matrix);
                printMatrix(rotatedMatrix, "Транспонированная матрица:");
            } catch (NumberFormatException e) {
                System.err.println("Ошибка в чтении первой строки!");
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения матрицы: " + e.getMessage());
        }


        System.out.println("-------------------------");
        System.out.println("Вариант 1, задача 10");
        System.out.println("Условие:");
        System.out.println("Входной файл хранит квадратную матрицу по принципу: строка представляет собой число. \nОпределить размерность. Построить 2-мерный массив, содержащий матрицу. \nВывести исходную матрицу и результат ее поворота на 90 градусов по часовой стрелке.");
        System.out.println("-------------------------\n");


    }

    private static int getMatrixDimension(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        if (line == null) {
            throw new IOException("Файл пуст");
        }
        int n = Integer.parseInt(line);
        if (n <= 0 || !reader.ready()) {
            throw new IOException("Недопустимый размер матрицы");
        }
        return n;
    }

    private static int[][] readMatrix(BufferedReader reader, int n) throws IOException {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            if (line == null) {
                throw new IOException("Неправильный размер матрицы");
            }
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(line.split(" ")[j]);
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix, String message) {
        System.out.println(message);
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.format("%4d", num);
            }
            System.out.println();
        }
    }

    private static int[][] rotateMatrixClockwise(int[][] matrix) {
        int n = matrix.length;
        int[][] rotatedMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }
}
