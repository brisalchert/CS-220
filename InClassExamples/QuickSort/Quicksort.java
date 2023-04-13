//----------------------------------------------------------------------------------------------------------------------
//  Quicksort.java              Authors: Brian Salchert, Aden D'Occhio
//
//  In-place Quicksort implementation in Java.
//----------------------------------------------------------------------------------------------------------------------

package QuickSort;

import java.util.Arrays;

public class Quicksort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // In-place QuickSort algorithm implementation
    public static void quickSort(int[] arr, int left, int right) {
        // Base case: if left index is less than right index
        if (left < right) {
            // Partition the array into two subarrays
            int partitionIndex = partition(arr, left, right);
            // Recursively sort the left subarray
            quickSort(arr, left, partitionIndex - 1);
            // Recursively sort the right subarray
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    // Partition the array into two subarrays
    public static int partition(int[] arr, int left, int right) {
        // Choose the last element as the pivot value
        int pivot = arr[right];
        // Initialize the index of the smaller element
        int i = left - 1;
        // Loop through the array from left to right-1
        for (int j = left; j < right; j++) {
            // If the current element is smaller than the pivot value
            if (arr[j] < pivot) {
                // Increment the index of the smaller element
                i++;
                // Swap the current element with the element at the index of the smaller element
                swap(arr, i, j);
            }
        }
        // Swap the pivot value with the element at the index of the smaller element + 1
        swap(arr, i + 1, right);
        // Return the index of the pivot value
        return i + 1;
    }

    // Swap two elements in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
