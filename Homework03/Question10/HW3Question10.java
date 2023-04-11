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

import java.util.LinkedList;

public class HW3Question10 {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};


    }

    public LinkedList<Integer> getCourseOrder(int numCourses, int[][] prerequisites) {
        // Initialize an adjacency matrix for a directed graph of the courses
        int[][] graph = new int[numCourses][numCourses];

        // Fill in the adjacency matrix for each prerequisite
        for (int[] prerequisite : prerequisites) {
            int nextCourse = prerequisite[0];
            int prevCourse = prerequisite[1];

            // Add an edge from the previous course to the next course
            graph[prevCourse][nextCourse] = 1;
        }

        // Find a course with no prerequisites

        return null;
    }
}
