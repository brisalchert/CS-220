//----------------------------------------------------------------------------------------------------------------------
//  HW2Question10.java               Author: Brian Salchert
//
//  Given an array of integers nums and an integer target, return indices of the two numbers such that they add up
//  to target.
//
//  You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//  You can return the answer in any order.
//----------------------------------------------------------------------------------------------------------------------

package Question10;

import Trees.ArrayBinarySearchTree;
import java.util.ArrayList;
import java.util.Arrays;

public class HW2Question10 {
    public static void main(String[] args) {
        Integer[] nums = {-95712,5812,481923,-589183};
        int target = -107260;
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(nums));

        System.out.println(sumTarget(list, target));
    }

    public static String sumTarget(ArrayList<Integer> list, int target) {
        ArrayBinarySearchTree<Integer> binarySearchTree = new ArrayBinarySearchTree<>();

        // Initialize binary search tree
        for (Integer num : list) {
            binarySearchTree.addElement(num);
        }

        // Search for target pair
        for (int num : list) {
            int diff = (target - num);

            // Check for a complementary value and ensure it has a different index
            if (binarySearchTree.search(diff) && (list.indexOf(diff) != list.indexOf(num))) {
                return "[" + list.indexOf(num) + "," + list.indexOf(diff) + "]";
            }
        }

        return "No such pair exists.";
    }
}
