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
        long argument;

        System.out.print("Enter a non-negative integer: ");
        argument = input.nextLong();
        System.out.println(argument + "! = " + factorial(argument));
    }

    /**
     * Computes the factorial of an input integer
     * @param n The input to compute the factorial of
     * @return n!
     * @throws IllegalArgumentException if the input is negative
     */
    public static long factorial(long n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative.");
        }

        if (n < 2) {
            return 1;
        }

        return (n * factorial(n - 1));
    }
}
