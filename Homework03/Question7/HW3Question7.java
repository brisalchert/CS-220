//----------------------------------------------------------------------------------------------------------------------
//  HW3Question7.java               Author: Brian Salchert
//
//  Given a string s, find the length of the longest substring without repeating characters.
//----------------------------------------------------------------------------------------------------------------------

package Question7;

import java.util.HashMap;

public class HW3Question7 {
    public static void main(String[] args) {
        String input = "abcdefg";

        System.out.println(longestSubstring(input));
    }

    public static int longestSubstring(String input) {
        // Create a HashMap for storing the characters in the substring
        HashMap<Character, Character> charMap = new HashMap<>();
        int length = 0;

        // Add each character to the HashMap until a repeat is found, incrementing the length
        int index = 0;
        while ((index < input.length()) && (!charMap.containsKey(input.charAt(index)))) {
            charMap.put(input.charAt(index), input.charAt(index));
            length++;

            index++;
        }

        // Check any further substring
        if (index < input.length()) {
            // Set the start index to the index after the first instance of the repeated character
            int startIndex = (input.indexOf(input.charAt(index)) + 1);

            int substringLength = longestSubstring(input.substring(startIndex));

            // Set length to the largest value of the two substrings
            if (substringLength > length) {
                length = substringLength;
            }
        }

        return length;
    }
}
