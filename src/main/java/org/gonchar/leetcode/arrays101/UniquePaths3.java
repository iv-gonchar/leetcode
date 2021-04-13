package org.gonchar.leetcode.arrays101;

public class UniquePaths3 {

    private int pathLength;

    private int[] start;

    private int[] end;

    private boolean[][] visited;

    private int[] path;

    private int pathIdx;

    public int uniquePathsIII(int[][] grid) {
        init(grid);
        return countPaths(start[0], start[1], grid);
    }

    private void init(int[][] grid) {
        // create visited matrix
        visited = new boolean[grid.length][grid[0].length];
        // reset other variables
        pathLength = 0;
        pathIdx = 0;

        // traverse matrix
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    pathLength++;
                } else if (grid[i][j] == -1) {
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    start = new int[]{i,j};
                } else if (grid[i][j] == 2) {
                    // maybe not needed
                    end = new int[]{i,j};
                }
            }
        }
        pathLength = 2 * (pathLength + 1);
        path = new int[pathLength];
    }

    public int countPaths(int x, int y, int[][] grid) {
        if (x<0 || x>grid.length-1 || y<0 || y>grid[x].length-1) {
            return 0;
        }
        if (visited[x][y]) {
            return 0;
        }
        if (grid[x][y] == 2) {
            if (pathIdx == pathLength) {
                return 1;
            } else {
                return 0;
            }
        }
        visited[x][y] = true;
        // add current node to stack
        path[pathIdx++] = x;
        path[pathIdx++] = y;
        int count = 0;
        count = count + countPaths(x, y+1, grid); // right
        count = count + countPaths(x-1, y, grid); // down
        count = count + countPaths(x, y-1, grid); // left
        count = count + countPaths(x+1, y, grid); // up

        // remove current node from stack
        pathIdx = pathIdx - 2;
        // allow this node to be visited in different paths
        visited[x][y] = false;
        return count;
    }

}
