package First;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstTask2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java MatrixRotation <filename>");
            System.exit(1);
        }
        int size = 0;
        List<int[]> matrixData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (size == 0) {
                    size = line.split(" ").length;
                }
                matrixData.add(Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray());
            }

            if (matrixData.size() != size) {
                throw new IOException("Неправильный размер матрицы.");
            }

            int[][] matrix = matrixData.stream().map(int[]::clone).toArray(int[][]::new);
            printMatrix(matrix, "Исходная матрица:");
            rotateMatrixClockwise(matrix);
            printMatrix(matrix, "Перевернутая матрица:");
        } catch (IOException e) {
            System.err.println("Ошибка чтения входящего файла: " + e.getMessage());

        }
    }

    private static void printMatrix(int[][] matrix, String message) {
        System.out.println(message);
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.format("%4d", element);
            }
            System.out.println();
        }
    }

    private static void rotateMatrixClockwise(int[][] matrix) {
        int size = matrix.length;
        for (int layer = 0; layer < size / 2; layer++) {
            int first = layer;
            int last = size - layer - 1;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
    }
}
