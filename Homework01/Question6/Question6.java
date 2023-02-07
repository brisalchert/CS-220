//----------------------------------------------------------------------------------------------------------------------
//  Question6.java              Author: Brian Salchert
//
//  Problem: Design a program which rotates an n x n 2D matrix by 90-degrees clockwise. The rotation must be done
//  directly, meaning the program cannot allocate another 2D matrix to perform the rotation.
//----------------------------------------------------------------------------------------------------------------------
package Question6;

public class Question6 {
    public static void main (String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int temp1;
        int temp2;

        // Print the input matrix
        System.out.print("Input matrix:\t");
        printMatrix(matrix);
        System.out.println();

        // Rotate the matrix 90-degrees clockwise one "ring" at a time, starting from the outside
        for (int n = 0; n < (matrix.length / 2); n++) {
            // Rotate four values at a time until the entire "ring" is rotated
            for (int m = n; m < (matrix.length - 1 - n); m++) {
                // Store the top right corner in temp1
                temp1 = matrix[m][matrix.length - 1 - n];

                // Replace top right corner with top left corner
                matrix[m][matrix.length - 1 - n] = matrix[n][m];

                // Store the bottom right corner in temp2
                temp2 = matrix[matrix.length - 1 - n][matrix.length - 1 - m];

                // Replace bottom right corner with top right corner
                matrix[matrix.length - 1 - n][matrix.length - 1 - m] = temp1;

                // Store the bottom left corner in temp1
                temp1 = matrix[matrix.length - 1 - m][n];

                // Replace bottom left corner with bottom right corner
                matrix[matrix.length - 1 - m][n] = temp2;

                // Replace top left corner with bottom left corner
                matrix[n][m] = temp1;
            }
        }

        // Print the output matrix
        System.out.print("Output matrix:\t");
        printMatrix(matrix);
    }

    //------------------------------------------------------------------------------------------------------------------
    //  Method for printing the matrix
    //------------------------------------------------------------------------------------------------------------------
    public static void printMatrix(int[][] matrix) {
        System.out.print("[");

        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");

            for (int j = 0; j < matrix[i].length; j++) {
                if (j < (matrix[i].length - 1)) {
                    System.out.print(matrix[i][j] + ",");
                }
                else {
                    System.out.print(matrix[i][j]);
                }
            }

            System.out.print("]");
        }

        System.out.print("]");
    }
}
