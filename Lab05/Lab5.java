//----------------------------------------------------------------------------------------------------------------------
//  Lab5.java               Author: Brian Salchert
//
//  Travelling Salesman Problem (TSP): Given a set of cities and distance between every pair of cities, the problem is
//  to find the shortest possible route that visits every city exactly once and returns to the starting point.
//
//  Problem 1
//  How to represent the input in your program? You can use adjacency list and adjacency matrix to represent this
//  in computer.
//
//      We can use a two-dimensional array to represent the adjacency matrix for the graph. That is, location [i][j]
//      in the matrix contains the distance between vertices i and j. Since this is an undirected graph, the
//      adjacency matrix will be symmetrical across the main diagonal.
//
//  Problem 2
//  How to find the shortest possible route?
//
//      The Traveling Salesman Problem, in mathematical terms, asks us to find the shortest Hamiltonian circuit in
//      the input graph. The most efficient known method for solving this problem is to compute the length of each
//      possible Hamiltonian circuit, although this has a runtime complexity of O(n!), which is undesirable. There
//      exist more efficient heuristic algorithms (that is, approximate algorithms) for finding a short path that is
//      not necessarily the shortest path, although these do not find the solution required for this problem.
//----------------------------------------------------------------------------------------------------------------------

import java.util.Iterator;
import java.util.LinkedList;

public class Lab5 {
    public static void main(String[] args) {
        // Initialize an adjacency matrix with [i][j] being the distance between cities i and j
        int[][] cityMatrix = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        // Generate the shortest Hamiltonian circuit in the graph
        LinkedList<Integer> shortestRoute = generateShortestRoute(cityMatrix, new LinkedList<>(), null,
                                                    0, Integer.MAX_VALUE);

        System.out.println();
        System.out.println("\tThe shortest route is: " + adjustRoute(shortestRoute) + " with total distance "
                            + getDistance(shortestRoute, cityMatrix) + ".");
    }

    //------------------------------------------------------------------------------------------------------------------
    //  The code for the following method was modeled off of a solution on GeeksForGeeks found here:
    //  https://www.geeksforgeeks.org/travelling-salesman-problem-implementation-using-backtracking/#
    //------------------------------------------------------------------------------------------------------------------

    /**
     * Finds the shortest Hamiltonian circuit among the cities in the graph (runtime complexity: O(n!) (not good, but
     * the best runtime for an exact answer)
     * @param distances the adjacency matrix for the cities
     * @param currentRoute the current route being traversed
     * @param finalRoute the current shortest route
     * @param currentDistance the distance of the current route
     * @param shortestDistance the distance of the final route
     * @return the shortest route
     */
    private static LinkedList<Integer> generateShortestRoute(int[][] distances, LinkedList<Integer> currentRoute,
                                                             LinkedList<Integer> finalRoute, int currentDistance,
                                                             int shortestDistance) {
        // If all cities have been visited, add the distance to return to the start point
        if (currentRoute.size() == distances.length) {
            currentDistance += distances[currentRoute.getLast()][0];
            currentRoute.add(0);

            // If the current route has a shorter distance than the current final route, set the new final route
            if (currentDistance < shortestDistance) {
                finalRoute = new LinkedList<>();
                finalRoute.addAll(currentRoute);
            }

            // Remove the repeat first city from the current route
            currentRoute.removeLast();

            return finalRoute;
        }

        // Visit each remaining city in the adjacency list
        for (int city = 0; city < distances.length; city++) {
            // If the current route is empty, add the first city
            if (currentRoute.isEmpty()) {
                currentRoute.add(city);
            }

            // Check if the city has been visited or if it is the same city
            if (!currentRoute.contains(city) && distances[currentRoute.getLast()][city] > 0) {
                // Add the city to the route and make a recursive call to finish permutations of the route
                currentDistance += distances[currentRoute.getLast()][city];
                currentRoute.add(city);

                finalRoute = generateShortestRoute(distances, currentRoute, finalRoute, currentDistance, shortestDistance);

                // If the current final route has a shorter distance than the previous shortest distance,
                // set the new shortest distance
                int finalRouteDistance = getDistance(finalRoute, distances);

                if (finalRouteDistance < shortestDistance) {
                    shortestDistance = finalRouteDistance;
                }

                // Remove the city from the route and subtract the last distance added
                int removedCity = currentRoute.removeLast();
                currentDistance -= distances[currentRoute.getLast()][removedCity];
            }
        }

        return finalRoute;
    }

    /**
     * Computes the distance for a particular route
     * @param route the route
     * @param distances the adjacency matrix for the graph of cities
     * @return the distance of the route
     */
    private static int getDistance(LinkedList<Integer> route, int[][] distances) {
        // Set the current city as the first in the route
        Iterator<Integer> routeIterator = route.iterator();
        int current = routeIterator.next();
        int totalDistance = 0;

        // Add distances between cities to the total distance until the route is completed
        while (routeIterator.hasNext()) {
            int next = routeIterator.next();
            totalDistance += distances[current][next];

            current = next;
        }

        // Return the total distance traveled
        return totalDistance;
    }

    /**
     * Adjusts the cities in the route to be 1-indexed instead of 0-indexed
     * @param route the route to adjust
     * @return the adjusted route
     */
    public static LinkedList<Integer> adjustRoute(LinkedList<Integer> route) {
        Iterator<Integer> routeIterator = route.iterator();
        LinkedList<Integer> adjustedRoute = new LinkedList<>();

        while (routeIterator.hasNext()) {
            adjustedRoute.add(routeIterator.next() + 1);
        }

        return adjustedRoute;
    }
}
