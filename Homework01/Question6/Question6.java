//----------------------------------------------------------------------------------------------------------------------
//  Question6.java              Author: Brian Salchert
//
//  Problem: Design a program which rotates an n x n 2D matrix by 90-degrees clockwise. The rotation must be done
//  directly, meaning the program cannot allocate another 2D matrix to perform the rotation.
//----------------------------------------------------------------------------------------------------------------------
package Question6;

public class Question6 {
    public static void main (String[] args) {
        Matrix matrix = new Matrix(4);

        // Print the input matrix
        System.out.print("Input matrix:\t");
        matrix.printMatrix();
        System.out.println();

        // Rotate the matrix 90 degrees clockwise
        matrix.rotateMatrix();

        // Print the output matrix
        System.out.print("Output matrix:\t");
        matrix.printMatrix();
    }
}
