//----------------------------------------------------------------------------------------------------------------------
//  Interval.java               Author: Brian Salchert
//
//  Class for Interval objects which contain an integer array of length 2 storing the interval.
//----------------------------------------------------------------------------------------------------------------------

package Interval;

public class Interval implements Comparable<Interval> {
    private int[] interval;

    /**
     * Constructor: Creates a new interval from a valid input interval
     * @param input the input interval
     * @throws IllegalArgumentException if the input interval is not of length 2
     */
    public Interval(int[] input) throws IllegalArgumentException {
        // Check that the input interval is of valid length
        if (input.length != 2) {
            throw new IllegalArgumentException("Invalid interval");
        }

        // Initialize the interval
        interval = input;
    }

    /**
     * Support method for getting the start value of an interval
     * @return the start value of the interval
     */
    private int getStart() {
        return this.interval[0];
    }

    /**
     * Support method for getting the end value of an interval
     * @return the end value of the interval
     */
    private int getEnd() {
        return this.interval[1];
    }

    /**
     * Compares two intervals and returns an integer value based on the result of the comparison
     * @param secondInterval the interval to be compared.
     * @return 1 if the first interval is after the second, -1 if the first interval is before the second, or 0 if
     *         the two intervals overlap
     */
    @Override
    public int compareTo(Interval secondInterval) {
        // Check if the second interval ends before the first begins
        if (interval[0] > secondInterval.interval[1]) {
            return 1;
        }

        // Check if the first interval ends before the second begins
        if (interval[1] < secondInterval.interval[0]) {
            return -1;
        }

        // Return 0 if the two intervals are overlapping
        return 0;
    }

    /**
     * Merges the current interval with another interval
     * @param secondInterval the interval to merge with
     * @return the merged interval
     * @throws IllegalArgumentException if the two intervals do not overlap
     */
    public Interval merge(Interval secondInterval) throws IllegalArgumentException {
        int[] mergedInterval = new int[2];

        if (this.compareTo(secondInterval) != 0) {
            throw new IllegalArgumentException("Invalid merge: Intervals are not overlapping");
        }

        mergedInterval[0] = Math.min(this.getStart(), secondInterval.getStart());
        mergedInterval[1] = Math.max(this.getEnd(), secondInterval.getEnd());

        return new Interval(mergedInterval);
    }

    /**
     * Converts the interval to a string
     * @return the interval as a string
     */
    public String toString() {
        return "[" + interval[0] + ", " + interval[1] + "]";
    }
}
