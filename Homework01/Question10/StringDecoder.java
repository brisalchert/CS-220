//----------------------------------------------------------------------------------------------------------------------
//  StringDecoder.java              Author: Brian Salchert
//
//  Problem: Given an encoded string, return its decoded string.
//
//  The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets
//  is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
//  You may assume that the input string is always valid; there are no extra white spaces, square brackets
//  are well-formed, etc.
//
//  Furthermore, you may assume that the original data does not contain any digits and that digits are
//  only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
//----------------------------------------------------------------------------------------------------------------------

package Question10;

public class StringDecoder {
    private final String NUMERALS = "1234567890";

    /**
     * Constructor: sets up a StringDecoder object
     */
    public StringDecoder() {
    }

    /**
     * Decodes the string s according to the specified rules in the class header
     * @param s the string to be decoded
     * @return the decoded string
     */
    public String decode(String s) {
        int multiplier;
        String initialString;
        String bracketedString;
        String remainderString;
        int remainderStringIndex;
        String decodedBracketedString;
        String decodedRemainderString;
        String finalString = "";

        // Base case
        if (!s.contains("[")) {
            return s;
        }

        // Set the initial string of characters before the multiplier
        initialString = getInitialString(s);

        // Add the initial string to finalString
        finalString += initialString;

        // Set the multiplier for the bracketed string
        if (initialString.equals("")) {
            multiplier = Integer.parseInt(s.substring(0, s.indexOf("[")));
        }
        else {
            multiplier = Integer.parseInt(s.substring(initialString.length(), s.indexOf("[")));
        }

        // Set bracketedString to the string to be multiplied
        bracketedString = getBracketedString(s, s.indexOf("["));

        // Find the index of remainderString in the original string
        remainderStringIndex = s.indexOf(bracketedString) + bracketedString.length() + 1;

        // Set remainderString to the substring after the outermost brackets
        remainderString = s.substring(remainderStringIndex);

        // Recursively decode bracketedString
        decodedBracketedString = decode(bracketedString);

        // Multiply decodedBracketedString and add it to the final string
        for (int i = 0; i < multiplier; i++) {
            finalString += decodedBracketedString;
        }

        // Recursively decode remainderString
        decodedRemainderString = decode(remainderString);

        // Add decodedRemainderString to the final string
        finalString += decodedRemainderString;

        return finalString;
    }

    /**
     * Gets the initial characters of an encoded string before the multiplier
     * @param s the encoded string
     * @return the initial string
     */
    private String getInitialString(String s) {
        int index = 0;
        String initialString = "";

        // If there is no initial string, return an empty string
        if (NUMERALS.indexOf(s.charAt(0)) != -1) {
            return initialString;
        }

        while (initialString.equals("")) {
            // Check if the character at index is a number
            if (NUMERALS.indexOf(s.charAt(index)) != -1) {
                initialString = s.substring(0, index);
            }

            index++;
        }

        return initialString;
    }

    /**
     * Gets the bracketed string that corresponds to the multiplier outside of the brackets
     * @param s the encoded string
     * @param start the starting index of the bracketed string
     * @return the bracketed string
     */
    private String getBracketedString(String s, int start) {
        int numUnclosedBrackets = 1;
        int index = (start + 1);

        while (numUnclosedBrackets > 0) {
            // Check if the current character is a closed bracket
            if (s.substring(index, (index + 1)).equals("]")) {
                numUnclosedBrackets--;
            }
            else {
                // Check if the current character is an open bracket
                if (s.substring(index, (index + 1)).equals("[")) {
                    numUnclosedBrackets++;
                }
            }

            index++;
        }

        // Return the substring inside the outermost set of brackets
        return s.substring((start + 1), (index - 1));
    }
}
