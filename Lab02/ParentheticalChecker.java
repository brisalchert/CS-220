//----------------------------------------------------------------------------------------------------------------------
//  ParentheticalChecker.java                Author: Brian Salchert
//
//  Class for determining if a given string s containing only parenthetical characters (i.e. "()[]{}") is a valid
//  string. To be valid, the string close every set of brackets with the correct type in the correct order.
//----------------------------------------------------------------------------------------------------------------------

import java.util.Stack;

public class ParentheticalChecker {
    // Create strings for checking opening and closing parentheses
    private final static String OPEN_PARENTHESES = "([{";
    private final static String CLOSED_PARENTHESES = ")]}";

    // Initialize a stack for holding the open parentheses
    private static Stack<Character> parentheses = new Stack<>();

    /**
     * Checks if the input string is a valid parenthetical expression
     * @param expression the input string
     * @return true if the expression is valid, false if not
     */
    public static boolean isValid(String expression) {
        // Convert the input string to a character array and iterate through each character
        for (char c : expression.toCharArray()) {
            // Check for an opening parenthesis and add to Stack if true
            if (OPEN_PARENTHESES.indexOf(c) != -1) {
                parentheses.push(c);
            }
            // Otherwise, check for a closing parenthesis
            else if (CLOSED_PARENTHESES.indexOf(c) != -1) {
                // Check if there are no open parentheses
                if (parentheses.isEmpty()) {
                    // String is invalid
                    return false;
                }

                // Check if the corresponding opening parenthesis in the stack is invalid
                if (CLOSED_PARENTHESES.indexOf(c) != OPEN_PARENTHESES.indexOf(parentheses.pop())) {
                    // String is invalid
                    return false;
                }
            }
        }

        // If the Stack is empty at this point, the expression is valid (no remaining opening parentheses)
        return parentheses.isEmpty();
    }
}
