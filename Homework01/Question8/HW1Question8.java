//----------------------------------------------------------------------------------------------------------------------
//  Question8.java              Author: Brian Salchert
//
//  Problem: You are given two non-empty linked lists representing two non-negative integers. The digits are
//  stored in reverse order, and each of their nodes contains a single digit. Add the two numbers
//  and return the sum as a linked list.
//
//  You may assume the two numbers do not contain any leading zero, except the number 0 itself
//----------------------------------------------------------------------------------------------------------------------

package Question8;

import java.util.Stack;
import java.util.LinkedList;

public class HW1Question8 {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        LinkedList<Integer> sumList = new LinkedList<>();
        int list1Value;
        int list2Value;
        int sum;

        // Populate the lists
        list1.add(9);
        list1.add(8);
        list1.add(3);
        list1.add(5);
        list1.add(9);
        list2.add(2);
        list2.add(1);
        list2.add(6);
        list2.add(8);

        // Print the initial lists
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        System.out.println();

        // Convert both lists' contents to integers
        list1Value = listToInt(list1);
        list2Value = listToInt(list2);

        // Add the two values
        sum = list1Value + list2Value;

        // Store the sum in the new linked list
        do {
            // Add the last digit of the sum to the list
            sumList.add(sum % 10);

            // Remove the last digit from sum
            sum /= 10;
        } while (sum != 0);

        // Print the new list
        System.out.println("List with sum: " + sumList);
    }

    public static int listToInt(LinkedList<Integer> list) {
        Stack<Integer> valueStack = new Stack<>();
        String number = "";

        // Push each item from the list onto the stack
        for (int value : list) {
            valueStack.push(value);
        }

        // Pop each item off the stack and add it to a String
        while (!valueStack.isEmpty()) {
            number += valueStack.pop();
        }

        // Parse the string as an int and return it
        return Integer.parseInt(number);
    }
}
