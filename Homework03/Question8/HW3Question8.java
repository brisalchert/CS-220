//----------------------------------------------------------------------------------------------------------------------
//  HW3Question8.java               Author: Brian Salchert
//
//  Given an array of intervals where intervals[i] = [start, end], merge all overlapping intervals, and return an
//  array of the non-overlapping intervals that cover all the intervals in the input.
//----------------------------------------------------------------------------------------------------------------------

package Question8;

import Interval.Interval;
import java.util.ArrayList;

public class HW3Question8 {
    public static void main(String[] args) {
        int[][] intervals = {{1,500},{405,601},{700,800},{801,829},{814,900}};

        System.out.println(mergeIntervals(intervals));
    }

    public static ArrayList<Interval> mergeIntervals(int[][] intervals) {
        ArrayList<Interval> intervalList = new ArrayList<>();
        ArrayList<Interval> mergedList = new ArrayList<>();

        // Initialize the interval objects and add them to the ArrayList
        for (int[] interval : intervals) {
            intervalList.add(new Interval(interval));
        }

        while (!intervalList.isEmpty()) {
            // Get the first interval from the intervalList
            Interval current = intervalList.get(0);

            // Merge the interval
            mergedList.add(recursiveMerge(current, intervalList));
        }

        return mergedList;
    }

    public static Interval recursiveMerge (Interval current, ArrayList<Interval> intervalList) {
        // Remove the current interval from the list if needed
        intervalList.remove(current);

        // Check each interval against the current one
        for (Interval interval : intervalList) {
            // If the intervals overlap, merge them
            if (current.compareTo(interval) == 0) {
                current = current.merge(interval);

                // Remove the merged interval from the list
                intervalList.remove(interval);

                // Recursively merge the new interval with any other overlaps
                 return recursiveMerge(current, intervalList);
            }
        }

        return current;
    }
}
