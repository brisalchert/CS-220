//----------------------------------------------------------------------------------------------------------------------
//  Question7.java              Author: Brian Salchert
//
//  Problem: Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing
//  together the nodes of the first two lists.
//----------------------------------------------------------------------------------------------------------------------

package Question7;

import java.util.LinkedList;

public class Question7 {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        int list1Index = 0;
        int list2Index = 0;

        // Populate the initial lists
        list1.add(-10);
        list1.add(7);
        list1.add(12);
        list1.add(27);
        list1.add(30);
        list1.add(54);
        list2.add(-3);
        list2.add(7);
        list2.add(40);
        list2.add(60);

        // Print the initial lists
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        System.out.println();

        // Iterate through both lists simultaneously and insert elements from list2 sorted into list1
        while (list2Index < list2.size()) {
            // If the last item is list2 is greater than the last item in list1,
            // add the item from list2 at the end of list1
            if (list1Index == list1.size()) {
                list1.add(list2.get(list2Index));

                list2Index++;
            }
            else {
                // If the item in list2 is <= the item in list1, add it before the item in list1
                if (list2.get(list2Index) <= list1.get(list1Index)) {
                    list1.add(list1Index, list2.get(list2Index));

                    list2Index++;
                    list1Index++;
                }
                else {
                    // Increment the index of list1 to the next item for evaluation;
                    list1Index++;
                }
            }
        }

        // Print the new merged list
        System.out.println("New merged list: " + list1);
    }
}
