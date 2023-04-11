//----------------------------------------------------------------------------------------------------------------------
//  HW3Question10.java               Author: Brian Salchert
//
//  There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
//  prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take
//  course ai.
//
//  • For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//
//  Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any
//  of them. If it is impossible to finish all courses, return an empty array.
//----------------------------------------------------------------------------------------------------------------------

package Question10;

import java.util.HashMap;
import java.util.LinkedList;

public class HW3Question10 {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};

        System.out.println(getCourseOrder(numCourses, prerequisites));
    }

    public static LinkedList<Integer> getCourseOrder(int numCourses, int[][] prerequisites) {
        LinkedList<Integer> courseOrder = new LinkedList<>();

        // Initialize a HashMap with keys of course numbers and values of "unlocked" courses
        HashMap<Integer,LinkedList<Integer>> unlockMap = new HashMap<>(numCourses);
        for (int course = 0; course < numCourses; course++) {
            unlockMap.put(course, new LinkedList<>());
        }

        // Initialize a HashMap with keys of course numbers and values of their prerequisites
        HashMap<Integer, LinkedList<Integer>> prerequisiteMap = new HashMap<>(numCourses);
        for (int course = 0; course < numCourses; course++) {
            prerequisiteMap.put(course, new LinkedList<>());
        }

        // Populate HashMaps with info from prerequisite array
        for (int[] prerequisite : prerequisites) {
            int followingCourse = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];

            // Add to unlockMap
            unlockMap.get(prerequisiteCourse).add(followingCourse);

            // Add to prerequisiteMap
            prerequisiteMap.get(followingCourse).add(prerequisiteCourse);
        }

        // Take the courses in the correct order
        takeCourses(unlockMap, prerequisiteMap, courseOrder, numCourses);

        return courseOrder;
    }

    public static void takeCourses(HashMap<Integer,LinkedList<Integer>> unlockMap,
                                   HashMap<Integer,LinkedList<Integer>> prerequisiteMap,
                                   LinkedList<Integer> courseOrder,
                                   int numCourses) {
        // Add all courses that have no remaining prerequisites
        for (Integer course : prerequisiteMap.keySet()) {
            if (prerequisiteMap.get(course).isEmpty() && !courseOrder.contains(course)) {
                // Add course to the final list
                courseOrder.add(course);

                // Remove fulfilled prerequisites from other courses
                for (Integer followingCourse : unlockMap.get(course)) {
                    // Remove the taken course from the prerequisites
                    prerequisiteMap.get(followingCourse).remove(course);
                }
            }
        }

        // If courses remain to be taken, call recursively
        if (courseOrder.size() < numCourses) {
            takeCourses(unlockMap, prerequisiteMap, courseOrder, numCourses);
        }
    }
}
