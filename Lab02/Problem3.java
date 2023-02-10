//----------------------------------------------------------------------------------------------------------------------
//  Problem3.java                Author: Brian Salchert
//
//  Driver class for ParentheticalChecker.java.
//----------------------------------------------------------------------------------------------------------------------

public class Problem3 {
    public static void main (String[] args) {
        String[] list = {"()", "()[]{}", "({[]}[])", "([)]", "{", "(([}]))"};

        // Check each string's validity and output the result
        for (String s : list) {
            System.out.println(ParentheticalChecker.isValid(s));
        }
    }
}
