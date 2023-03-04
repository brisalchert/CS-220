//----------------------------------------------------------------------------------------------------------------------
//  BinarySearchTest.java               Author: Brian Salchert
//
//  Class for testing the binary search implementation
//----------------------------------------------------------------------------------------------------------------------

package BinarySearchTest;

import java.util.ArrayList;

public class BinarySearchTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] data = {3, 12, 13, 20, 26, 31, 36, 40, 50, 55};

        for (int element : data) {
            list.add(element);
        }

        System.out.println(binarySearch(list, 40, 0, list.size() - 1));
    }

    public static boolean binarySearch(ArrayList<Integer> list, int target, int low, int high) {
        if (low > high) {
            return false;
        }
        else {
            int mid = (low + high) / 2;

            if (target == list.get(mid)) {
                return true;
            }
            else {
                if (target < list.get(mid)) {
                    return binarySearch(list, target, low, mid - 1);
                }
                else {
                    return binarySearch(list, target, mid + 1, high);
                }
            }
        }
    }
}
