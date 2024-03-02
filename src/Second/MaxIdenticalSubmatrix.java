package Second;
import java.util.Stack;
class MaxIdenticalSubmatrix {

    static class MatrixElement {
        final int value;
        final int row;
        final int column;

        MatrixElement(int value, int row, int column) {
            this.value = value;
            this.row = row;
            this.column = column;
        }
    }

    public static MaxIdenticalSubmatrix.MatrixElement findLargestSubmatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Matrix cannot be empty.");
        }

        int maxWidth = 0;
        int maxHeight = 0;
        int maxLeft = 0;
        int maxTop = 0;

        Stack<MatrixElement> stack = new Stack<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                int currentValue = matrix[row][column];

                while (!stack.isEmpty() && stack.peek().value > currentValue) {
                    MatrixElement top = stack.pop();

                    int width = stack.isEmpty() ? column : column - stack.peek().column - 1;
                    int height = top.row - stack.peek().row + 1;

                    if (width * height > maxWidth * maxHeight) {
                        maxWidth = width;
                        maxHeight = height;
                        maxLeft = stack.isEmpty() ? 0 : stack.peek().column + 1;
                        maxTop = top.row;
                    }
                }

                stack.push(new MaxIdenticalSubmatrix.MatrixElement(currentValue, row, column));
            }
        }

        // Process the remaining elements in the stack
        while (!stack.isEmpty()) {
            MatrixElement top = stack.pop();

            int width = stack.isEmpty() ? matrix[0].length : matrix[0].length - stack.peek().column - 1;
            int height = top.row + 1;
            if (!stack.isEmpty()) {
                height = height - stack.peek().row;
            }

            if (width * height > maxWidth * maxHeight) {
                maxWidth = width;
                maxHeight = height;
                maxLeft = stack.isEmpty() ? 0 : stack.peek().column + 1;
                maxTop = top.row;
            }
        }

        // Print the largest rectangular submatrix
        System.out.println("The largest rectangular submatrix is:");
        for (int i = maxTop; i > 0; i--) {
            for (int j = maxLeft + maxWidth - 1; j >= 0; j--) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        return new MaxIdenticalSubmatrix.MatrixElement(matrix[maxTop][maxLeft], maxTop, maxLeft);
    }
}