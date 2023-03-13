//----------------------------------------------------------------------------------------------------------------------
//  HW2Question8.java               Author: Brian Salchert
//
//  Given an integer array nums and an integer k, return the kth largest element in the array.
//
//  Note that it is the kth largest element in the sorted order, not the kth distinct element
//----------------------------------------------------------------------------------------------------------------------

package Question8;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HW2Question8 {
    public static void main(String[] args) {
        int[] nums = {-40, 35, 2, -1, 78, 406, 78, 78, 23};
        int k = 7;
        // Initialize the heap with a reverse order comparator so the largest element is the highest priority
        PriorityQueue<Integer> numHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // Add the elements in the array to the heap
        for (int num : nums) {
            numHeap.add(num);
        }

        // Remove the largest elements before the kth largest element
        for (int i = 1; i < k; i++) {
            numHeap.remove();
        }

        // Print the kth largest element
        System.out.println(numHeap.remove());
    }
}
