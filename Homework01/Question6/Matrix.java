//----------------------------------------------------------------------------------------------------------------------
//  Matrix.java              Author: Brian Salchert
//
//  Class for creating and rotating an n x n matrix 90 degrees clockwise.
//----------------------------------------------------------------------------------------------------------------------
package Question6;

public class Matrix {
    private static int[][] matrix;

    //------------------------------------------------------------------------------------------------------------------
    //  Constructor: Generates and populates a square matrix of a given size with values 1 - size^2.
    //------------------------------------------------------------------------------------------------------------------
    public Matrix(int size) {
        matrix = new int[size][size];
        int count = 1;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = count;
                count++;
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //  Rotates the matrix in place 90 degrees clockwise.
    //------------------------------------------------------------------------------------------------------------------
    public void rotateMatrix() {
        // Rotate the matrix 90-degrees clockwise one "ring" at a time, starting from the outside
        for (int level = 0; level < (matrix.length / 2); level++) {
            // Rotate four values at a time until the entire "ring" is rotated
            for (int offset = level; offset < (matrix.length - 1 - level); offset++) {
                rotateValues(level, offset);
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //  Rotates four values 90 degrees clockwise in the matrix.
    //------------------------------------------------------------------------------------------------------------------
    private void rotateValues(int row, int column) {
        // Store first value in temp
        int temp = matrix[row][column];
        int reflectedRow = matrix.length - 1 - row;
        int reflectedColumn = matrix.length - 1 - column;

        // Replace first value with second value
        matrix[row][column] = matrix[reflectedColumn][row];

        // Replace second value with third value
        matrix[reflectedColumn][row] = matrix[reflectedRow][reflectedColumn];

        // Replace third value with fourth value
        matrix[reflectedRow][reflectedColumn] = matrix[column][reflectedRow];

        // Replace fourth value with first value
        matrix[column][reflectedRow] = temp;
    }

    //------------------------------------------------------------------------------------------------------------------
    //  Method for printing the matrix.
    //------------------------------------------------------------------------------------------------------------------
    public void printMatrix() {
        System.out.print("[");

        for (int row = 0; row < matrix.length; row++) {
            System.out.print("[");

            for (int column = 0; column < matrix[row].length; column++) {
                if (column < (matrix[row].length - 1)) {
                    System.out.print(matrix[row][column] + ",");
                }
                else {
                    System.out.print(matrix[row][column]);
                }
            }

            System.out.print("]");
        }

        System.out.print("]");
    }
}
