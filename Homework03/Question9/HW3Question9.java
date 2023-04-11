//----------------------------------------------------------------------------------------------------------------------
//  HW3Question9.java               Author: Brian Salchert
//
//  Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number
//  of islands.
//
//  An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
//  You may assume all four edges of the grid are all surrounded by water.
//----------------------------------------------------------------------------------------------------------------------

package Question9;

public class HW3Question9 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','0'},
                {'0','1','1','0'},
                {'1','1','0','1'},
                {'0','1','1','0'}
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int count = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == '1') {
                    exploreIsland(grid, row, column);

                    count++;
                }
            }
        }

        return count;
    }

    public static void exploreIsland(char[][] grid, int row, int column) {
        if (grid[row][column] == '1') {
            // Mark the coordinate as explored
            grid[row][column] = '2';

            // Find adjacent land to the west
            if (column > 0) {
                exploreIsland(grid, row, (column - 1));
            }

            // Find adjacent land to the east
            if (column < (grid[row].length - 1)) {
                exploreIsland(grid, row, (column + 1));
            }

            // Find adjacent land to the north
            if (row > 0) {
                exploreIsland(grid, (row - 1), column);
            }

            // Find adjacent land to the south
            if (row < (grid.length - 1)) {
                exploreIsland(grid, (row + 1), column);
            }
        }
    }
}
