//----------------------------------------------------------------------------------------------------------------------
//  Question6.java              Author: Brian Salchert
//
//  Problem: Design a program which rotates an n x n 2D matrix by 90-degrees clockwise. The rotation must be done
//  directly, meaning the program cannot allocate another 2D matrix to perform the rotation.
//----------------------------------------------------------------------------------------------------------------------

public class Question6 {
    public static void main (String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // Print the input matrix
        System.out.print("Input matrix:\t");
        printMatrix(matrix);
        System.out.println();



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
