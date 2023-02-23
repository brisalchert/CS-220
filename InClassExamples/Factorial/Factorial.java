//----------------------------------------------------------------------------------------------------------------------
//  Factorial.java              Author: Brian Salchert
//
//  Class with method for taking an integer and computing its factorial.
//----------------------------------------------------------------------------------------------------------------------

package Factorial;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int argument;

        System.out.print("Enter a non-negative integer: ");
        argument = input.nextInt();
        System.out.println(argument + "! = " + factorial(argument));
    }

    public static int factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative.");
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        return (n * factorial(n - 1));
    }
}