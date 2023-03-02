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

        list.add(3);
        list.add(12);
        list.add(13);
        list.add(20);
        list.add(26);
        list.add(31);
        list.add(36);
        list.add(40);
        list.add(50);
        list.add(55);

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
