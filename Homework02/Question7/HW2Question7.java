//----------------------------------------------------------------------------------------------------------------------
//  HW2Question7.java               Author: Brian Salchert
//
//  Given an array of meeting time intervals (intervals) where intervals[i] = [start, end], return the minimum number
//  of conference rooms required.
//----------------------------------------------------------------------------------------------------------------------

package Question7;

import java.util.ArrayList;
import Trees.LinkedBinarySearchTree;

public class HW2Question7 {
    public static void main(String[] args) {
        int[][] meetingTimes = {{7,10}, {2,4}, {0, 30}, {5, 10}, {15, 20}};
        ArrayList<Interval> intervals = new ArrayList<>();
        ArrayList<LinkedBinarySearchTree<Interval>> rooms = new ArrayList<>();
        int numRooms = 0;

        // Add each meeting to the array list of intervals
        for (int[] meeting : meetingTimes) {
            Interval nextMeeting = new Interval(meeting);

            intervals.add(nextMeeting);
        }

        // Add each meeting to the list of conference rooms, tracking the number of rooms used
        for (Interval meeting : intervals) {
            numRooms += addMeeting(meeting, rooms);
        }

        System.out.println("Rooms required: " + numRooms);
    }

    /**
     * Adds a meeting to the list of conference rooms, creating a new room if necessary
     * @param meeting the meeting to be added to the list
     * @param rooms the list of conference rooms
     * @return 0 if the meeting fits in an existing room, 1 if the meeting requires a new room
     */
    public static int addMeeting(Interval meeting, ArrayList<LinkedBinarySearchTree<Interval>> rooms) {
        // Iterate through each room in the list of conference rooms
        for (LinkedBinarySearchTree<Interval> room : rooms) {
            // Attempt to add the meeting to the current room
            try {
                room.addElement(meeting);

                return 0;
            }
            // If the meeting overlaps with any meetings in the room (compareTo returns 0), skip this room
            catch (IllegalArgumentException error) {
                System.out.println("Meeting " + meeting + " does not fit in room " + rooms.indexOf(room));
            }
        }

        // If the meeting does not fit in any current rooms, make a new room for it
        LinkedBinarySearchTree<Interval> newRoom = new LinkedBinarySearchTree<>(meeting);
        rooms.add(newRoom);

        return 1;
    }

    /**
     * Class for Interval objects which contain an integer array of length 2 storing the interval.
     */
    public static class Interval implements Comparable<Interval> {
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
         * Converts the interval to a string
         * @return the interval as a string
         */
        public String toString() {
           return "[" + interval[0] + ", " + interval[1] + "]";
        }
    }
}
