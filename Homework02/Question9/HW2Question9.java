//----------------------------------------------------------------------------------------------------------------------
//  HW2Question9.java               Author: Brian Salchert
//
//  Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes
//  with a value in the inclusive range [low, high].
//----------------------------------------------------------------------------------------------------------------------

package Question9;

import Trees.ArrayBinarySearchTree;
import java.util.ArrayList;
import java.util.Arrays;

public class HW2Question9 {
    public static void main(String[] args) {
        Integer[] root = {10, 5, 15, 3, 7, 13, 18, -3, 4, null, 8, 11};
        int low = 15;
        int high = 18;
        int sum = 0;
        ArrayList<Integer> tree = new ArrayList<>(Arrays.asList(root));
        ArrayBinarySearchTree<Integer> binarySearchTree;

        // Create the binary search tree using the ArrayList
        binarySearchTree = new ArrayBinarySearchTree<>(tree);

        // Iterate over the integers within the low and high bounds
        for (int i = low; i <= high; i++) {
            // If the value exists in the tree, add it to the sum
            if (binarySearchTree.search(i)) {
                sum += i;
            }
        }

        System.out.println("Sum: " + sum);
    }
}
