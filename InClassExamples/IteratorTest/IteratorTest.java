//----------------------------------------------------------------------------------------------------------------------
//  IteratorTest.java               Author: Brian Salchert
//
//  Class for testing the iterator interface in java.
//----------------------------------------------------------------------------------------------------------------------

package IteratorTest;
import java.util.Iterator;
import java.util.ArrayList;

public class IteratorTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> newList = new ArrayList<>();
        Iterator<String> iterator;

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        iterator = list.iterator();

        while (iterator.hasNext()) {
            newList.add(iterator.next());
        }

        for (String element : list) {
            System.out.println(element);
        }

        for (String element : newList) {
            System.out.println(element);
        }
    }
}
