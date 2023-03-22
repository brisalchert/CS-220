//----------------------------------------------------------------------------------------------------------------------
//  Lab3Problem2.java               Author: Brian Salchert
//
//  Given an integer (1 <= num <= 3999), convert it to a roman numeral.
//----------------------------------------------------------------------------------------------------------------------

import java.util.Scanner;

public class Lab3Problem2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input an integer (0 - 3999): ");
        System.out.println("Roman Numeral: " + intToRomanNum(input.nextInt()));
    }

    public static String intToRomanNum(int integer) {
        String result = "";
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;

        // Loop until integer = 0
        while (integer > 0) {
            // Check if the integer contains the next largest numeral
            if (integer >= values[index]) {
                // Add the numeral to the result
                result += numerals[index];

                // Subtract the value of the numeral from the integer
                integer -= values[index];
            }
            else {
                // Increment the index to the next numeral
                index++;
            }
        }

        return result;
    }
}
