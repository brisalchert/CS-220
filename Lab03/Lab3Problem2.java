//----------------------------------------------------------------------------------------------------------------------
//  Lab3Problem2.java               Author: Brian Salchert
//
//  Given an integer (1 <= num <= 3999), convert it to a roman numeral.
//----------------------------------------------------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Lab3Problem2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input an integer (0 - 3999): ");
        System.out.println("Roman Numeral: " + intToRomanNum(input.nextInt()));
    }

    public static String intToRomanNum(int integer) {
        String result = "";
        HashMap<Integer, Character> numeralMap = new HashMap<>();
        int[] nums = {1000, 500, 100, 50, 10, 5, 1};
        ArrayList<Integer> numerals = new ArrayList();

        // Initialize ArrayList with nums
        for (int num : nums) {
            numerals.add(num);
        }

        // Initialize the HashMap with roman numeralMap
        numeralMap.put(1000, 'M');
        numeralMap.put(500, 'D');
        numeralMap.put(100, 'C');
        numeralMap.put(50, 'L');
        numeralMap.put(10, 'X');
        numeralMap.put(5, 'V');
        numeralMap.put(1, 'I');

        // Generate the numeral
        for (int numeralIndex = 0; numeralIndex < numerals.size(); numeralIndex += 2) {
            int multiplier = (integer / numerals.get(numeralIndex));

            // Cases for multiplier < 5
            if (multiplier < 5) {
                // Special case for multiplier of 4
                if (multiplier == 4) {
                    // Append the numeral itself
                    result += numeralMap.get(numerals.get(numeralIndex));

                    // Append the numeral 5 times larger
                    result += numeralMap.get(numerals.get(numeralIndex - 1));

                    // Subtract the appended value from the integer
                    integer -= (multiplier * numerals.get(numeralIndex));
                }
                else {
                    // Multiply the numeral
                    for (int i = 0; i < multiplier; i++) {
                        result += numeralMap.get(numerals.get(numeralIndex));
                    }

                    // Subtract the appended value from the integer
                    integer -= (multiplier * numerals.get(numeralIndex));
                }
            }
            // Cases for multiplier >= 5
            else {
                // Special case for multiplier of 9
                if (multiplier == 9) {
                    // Append the numeral itself
                    result += numeralMap.get(numerals.get(numeralIndex));

                    // Append the numeral 10 times larger
                    result += numeralMap.get(numerals.get(numeralIndex - 2));

                    // Subtract the appended value from the integer
                    integer -= (multiplier * numerals.get(numeralIndex));
                }
                else {
                    // Append the numeral 5 times larger
                    result += numeralMap.get(numerals.get(numeralIndex - 1));

                    // Multiply the remaining numerals
                    for (int i = 5; i < multiplier; i++) {
                        result += numeralMap.get(numerals.get(numeralIndex));

                    // Subtract the appended value from the integer
                    integer -= (multiplier * numerals.get(numeralIndex));
                    }
                }
            }
        }

        return result;
    }
}
