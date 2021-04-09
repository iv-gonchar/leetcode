package org.gonchar.leetcode.arrays101;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumPathEffort {

    private Map<Integer, Cell> all = new HashMap<>();

    private PriorityQueue<Point> toCompute = new PriorityQueue<>(new PComparator());

    public int minimumEffortPath(int[][] heights) {
        Cell start = all.computeIfAbsent(key(0, 0), k -> new Cell(0, 0));
        start.effort = 0;
        toCompute.add(new Point(start));
        while (toCompute.size() != 0) {
            Point point = toCompute.poll();
            Cell current = all.get(point.key());
            if (isTarget(heights, current)) {
                return current.effort;
            }
            // for each its neighbours compute effort and put into toCompute
            computeNeighbour(heights, current.row, current.col - 1, current);
            computeNeighbour(heights, current.row, current.col + 1, current);
            computeNeighbour(heights, current.row - 1, current.col, current);
            computeNeighbour(heights, current.row + 1, current.col, current);
            current.computed = true;
        }
        return 0;
    }

    private boolean isTarget(int[][] heights, Cell current) {
        return (heights.length - 1 == current.row) && (heights[current.row].length - 1 == current.col);
    }

    private int key(int r, int c) {
        return 100 * r + c;
    }

    private boolean isValidCell(int[][] heights, int i, int j) {
        return i >= 0 && i < heights.length && j >= 0 && j < heights[i].length;
    }

    private void computeNeighbour(int[][] heights, int i, int j, Cell current) {
        if (!isValidCell(heights, i, j)) {
            return;
        }
        Cell neighbour = all.computeIfAbsent(key(i, j), k -> new Cell(i, j));
        if (neighbour.computed) {
            return;
        }
        int effort = Math.abs(heights[i][j] - heights[current.row][current.col]);
        effort = Math.max(effort, current.effort);
        if (effort < neighbour.effort) {
            neighbour.effort = effort;
            toCompute.add(new Point(neighbour));
        }
    }

    public static class Point {
        final int effort;
        final byte row;
        final byte col;

        public Point(Cell cell) {
            this.effort = cell.effort;
            this.col = cell.col;
            this.row = cell.row;
        }

        public int key() {
            return 100 * row + col;
        }
    }

    public static class PComparator implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
            return p1.effort - p2.effort;
        }
    }

    public static class Cell {
        byte row;
        byte col;
        int effort = 1000001;
        boolean computed = false;

        public Cell(int row, int col) {
            this.row = (byte) row;
            this.col = (byte) col;
        }

        public String toString() {
            return "[" + row + "," + col + "] ef=" + effort + ", c=" + computed;
        }
    }
}
