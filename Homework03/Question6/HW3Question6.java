//----------------------------------------------------------------------------------------------------------------------
//  HW3Question6.java               Author: Brian Salchert
//
//  Given an array of integers nums and an integer target, return indices of the two numbers such that they add up
//  to target.
//
//  You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//  You can return the answer in any order.
//
//  Can you come up with an algorithm that is less than O(n2) time complexity?
//----------------------------------------------------------------------------------------------------------------------

package Question6;

import java.util.HashMap;
import java.util.ArrayList;

public class HW3Question6 {
    public static void main(String[] args) {
        int[] nums = {2,5,1,61,3,5,4};
        int target = 10;

        System.out.println(sumTarget(nums, target));
    }

    public static String sumTarget(int[] nums, int target) {
        // Initialize a new HashMap with keys of the values in nums[] and values of ArrayLists of indices
        HashMap<Integer, ArrayList<Integer>> numsMap = new HashMap<>(nums.length);

        // Place each number in the hashmap
        for (int index = 0; index < nums.length; index++) {
            ArrayList<Integer> indexList = new ArrayList<>();
            indexList.add(index);

            // If the key already exists in the HashMap, update the ArrayList with the new index
            if (numsMap.containsKey(nums[index])) {
                indexList.addAll(numsMap.get(nums[index]));
            }

            // Add the index list to the HashMap
            numsMap.put(nums[index], indexList);
        }

        // Check for a pair with sum target for each value in nums[]
        for (int index = 0; index < nums.length; index++) {
            // Calculate the difference between the current value and target
            int diff = (target - nums[index]);

            // Check if the difference exists in the HashMap
            if (numsMap.containsKey(diff)) {
                // Pick the first non-duplicate index difference
                for (int position : numsMap.get(diff)) {
                    if (index != position) {
                        return printIndices(index, position);
                    }
                }
            }
        }

        // Inform the user that no pair exists
        return "No such pair exists.";
    }

    /**
     * Prints the input indices as an ordered pair
     * @param index1 the first index
     * @param index2 the second index
     * @return the ordered pair as a string
     */
    public static String printIndices(int index1, int index2) {
        return ("[" + index1 + "," + index2 + "]");
    }
}
