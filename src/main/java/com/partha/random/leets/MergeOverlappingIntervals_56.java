package com.partha.random.leets;

import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals_56 {
    /**
     * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,
     **/

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 9}, {9, 11}, {8, 10}, {2, 4}, {15, 18}, {16, 17}};
        MergeOverlappingIntervals_56 m = new MergeOverlappingIntervals_56();
        m.sortIntervals(intervals);
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
    }


    private void sortIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[0], b[0]);
        });
    }
}
