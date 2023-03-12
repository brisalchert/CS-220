//----------------------------------------------------------------------------------------------------------------------
//  HW2Question6.java               Author: Brian Salchert
//
//  Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to
//  search target in nums. If target exists, then return its index. Otherwise, return -1.
//----------------------------------------------------------------------------------------------------------------------

package Question6;

import java.util.ArrayList;
import Trees.LinkedBinarySearchTree;

public class HW2Question6 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        ArrayList<Integer> numsList = new ArrayList<>();
        LinkedBinarySearchTree<Integer> searchTree = new LinkedBinarySearchTree<>();

        // Add each number to the ArrayList (used for access to the "indexOf" method
        for (int num : nums) {
            numsList.add(num);
        }

        // Add each number to the binary search tree
        for (int num : nums) {
            searchTree.addElement(num);
        }

        // Check if the target is in the binary search tree
        if (searchTree.search(target)) {
            // Print positive result
            System.out.println(numsList.indexOf(target));
        }
        else {
            // Print negative result
            System.out.println(-1);
        }
    }
}
