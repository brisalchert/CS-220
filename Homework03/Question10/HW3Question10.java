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
        int numCourses = 8;
        int[][] prerequisites = {{1,0},{2,1},{7,5},{7,4},{6,7},{3,0},{7,3}};

        int[] result = getCourseOrder(numCourses, prerequisites);

        System.out.print("[");
        for (int index = 0; index < result.length; index++) {
            System.out.print(result[index]);

            if (!(index == (result.length - 1))) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    public static int[] getCourseOrder(int numCourses, int[][] prerequisites) {
        LinkedList<Integer> courseOrder = new LinkedList<>();
        int[] result = new int[numCourses];

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

        // Check for a cycle in the adjacency list
        if (detectCycle(unlockMap, numCourses)) {
            return new int[0];
        }

        // Take the courses in the correct order
        takeCourses(unlockMap, prerequisiteMap, courseOrder, numCourses);

        // Convert LinkedList to int[]
        for (int index = 0; index < courseOrder.size(); index++) {
            result[index] = courseOrder.get(index);
        }

        return result;
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

    //------------------------------------------------------------------------------------------------------------------
    //  The following two methods were obtained from: https://www.geeksforgeeks.org/detect-cycle-in-a-graph/.
    //  Source cited in the Discussion and Analysis document.
    //------------------------------------------------------------------------------------------------------------------

    public static boolean detectCycle(HashMap<Integer,LinkedList<Integer>> graph, int numCourses) {
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        // Call the recursive cycle detection function for each tree in the forest
        for (int index = 0; index < numCourses; index++) {
            if (componentDetectCycle(graph, index, visited, recStack)) {
                return true;
            }
        }

        return false;
    }

    private static boolean componentDetectCycle(HashMap<Integer,LinkedList<Integer>> graph, int index,
                                                boolean[] visited, boolean[] recStack) {
        // If the node cycles back (has already been marked in recStack), return true
        if (recStack[index]) {
            return true;
        }

        // If the node has already been visited (part of the same forest as previous check), return false
        if (visited[index]) {
            return false;
        }

        // Mark the current node as visited
        visited[index] = true;

        // Mark the current node in recStack
        recStack[index] = true;

        // Check all the adjacent nodes of the current node
        for (int adjacency : graph.get(index)) {
            if (componentDetectCycle(graph, adjacency, visited, recStack)) {
                return true;
            }
        }

        // Unmark the current node from recStack
        recStack[index] = false;

        return false;
    }
}
