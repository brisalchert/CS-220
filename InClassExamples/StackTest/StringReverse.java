//----------------------------------------------------------------------------------------------------------------------
//  StringReverse.java              Author: Brian Salchert
//
//  Algorithm for reversing an input string using a stack.
//----------------------------------------------------------------------------------------------------------------------

package StackTest;
import java.util.Scanner;

public class StringReverse {
    public static void main (String[] args) {
        ArrayStack<Character> arrayStack = new ArrayStack<Character>(20);
        String forwards;
        Scanner input;
        char[] letters;
        String backwards = "";

        input = new Scanner(System.in);

        System.out.print("Enter a string to reverse: ");
        forwards = input.nextLine();
        System.out.println();

        letters = forwards.toCharArray();

        for (char letter : letters) {
            arrayStack.push(letter);
        }

        for (int index = 0; index < forwards.length(); index++) {
            backwards += arrayStack.pop().toString();
        }

        System.out.println("Reversed String: " + backwards);
    }
}
