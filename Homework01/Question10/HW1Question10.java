//----------------------------------------------------------------------------------------------------------------------
//  HW1Question10.java              Author: Brian Salchert
//
//  Driver class for StringDecoder.java. Used to test the decoding algorithm using several test cases.
//----------------------------------------------------------------------------------------------------------------------

package Question10;

public class HW1Question10 {
    public static void main(String[] args) {
        String[] testInput = {"3[a]2[bc]", "3[a2[c]]", "2[abc]3[cd]ef"};
        StringDecoder decoder = new StringDecoder();

        // Test each input
        for (String input : testInput) {
            System.out.println("Input: " + input);
            System.out.println("Output: " + decoder.decode(input));
            System.out.println();
        }
    }
}
