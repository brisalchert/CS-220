//----------------------------------------------------------------------------------------------------------------------
//  Lab3Problem1.java               Author: Brian Salchert
//
//  Given a string s, find the first non-repeating character in it and return its index. If it does not exist,
//  return -1.
//----------------------------------------------------------------------------------------------------------------------

import java.util.Scanner;

public class Lab3Problem1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s;

        // Ask user for input and take input
        System.out.print("Input string: ");
        s = input.next();

        // Find the index of the first non-repeating character
        System.out.println("Output: " + firstNonRepeating(s));
    }

    /**
     * Finds the index of the first non-repeating character in s, or returns -1 if there are none
     * @param s the input string
     * @return the index of the first non-repeating character in s, or -1 if it does not exist
     */
    public static int firstNonRepeating(String s) {
        String checkedCharacters = "";

        for (Character character : s.toCharArray()) {
            // Check if the character has not already been checked
            if (checkedCharacters.indexOf(character) == -1) {
                // Create a substring of s beginning after the character to be checked
                String substring = s.substring(s.indexOf(character) + 1);

                // Check if the substring contains a repeat of the character
                if (substring.indexOf(character) > -1) {
                    // Add the character to the checkedCharacters
                    checkedCharacters += character;
                }
                else {
                    // Return the index of the character that does not repeat
                    return s.indexOf(character);
                }
            }
        }

        return -1;
    }
}
