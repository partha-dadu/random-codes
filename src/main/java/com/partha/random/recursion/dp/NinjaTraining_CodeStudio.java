package com.partha.random.recursion.dp;

import java.util.Arrays;

public class NinjaTraining_CodeStudio {

    /**
     * The Ninja is training in a new game. The game is played as follows:
     * [[1,2,5], [3,1,1], [3,3,3]]
     * Each cell in the grid represents a number that a ninja can learn on that particular day
     * <p>
     * Calculate the maximum number of ninja levels that can be learned in this game.
     * P.S. The ninja can learn at most one level per day.
     **/

    public static void main(String[] args) {
        NinjaTraining_CodeStudio obj = new NinjaTraining_CodeStudio();
        int[][] grid = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        int result = obj.learnNinja(grid);
        System.out.println("Result " + result);
        int[][] grid2 = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}, {1, 1, 1}};
        int result2 = obj.learnNinja(grid2);
        System.out.println("Result " + result2);
        int[][] grid3 = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}, {1, 1, 1}, {1, 1, 1}};
        int result3 = obj.ninjaTrainingTabulation(grid3);
        System.out.println("Result 3 " + result3);
    }

    public int learnNinja(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return learnNinjaDP(grid, 0, 3, dp);
    }

    public int learnNinjaDP(int[][] grid, int day, int lastTask, int[][] dp) {
        if (day == grid.length - 1) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < grid[0].length; i++) {
                if (i != lastTask) {
                    max = Math.max(max, grid[day][i]);
                }
            }
            return max;
        }
        if (dp[day][lastTask] != -1) {
            return dp[day][lastTask];
        }
        int max = Integer.MIN_VALUE;
        for (int task = 0; task < grid[0].length; task++) {
            if (lastTask != task) {
                max = Math.max(max, grid[day][task] + learnNinjaDP(grid, day + 1, task, dp));
            }
        }
        dp[day][lastTask] = max;
        return dp[day][lastTask];
    }

    public int ninjaTrainingTabulation(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        dp[0][0] = Math.max(grid[0][1], grid[0][2]);
        dp[0][1] = Math.max(grid[0][0], grid[0][2]);
        dp[0][2] = Math.max(grid[0][0], grid[0][1]);
        dp[0][3] = Math.max(grid[0][1], Math.max(grid[0][1], grid[0][2]));



        for (int day = 1; day < grid.length; day++) {
            for (int last = 0; last < 4; last++) {
                int max = Integer.MIN_VALUE;

                for(int task = 0; task < 3; task++){
                    if(task != last){
                        max = Math.max(max, grid[day][task] + dp[day - 1][task]);
                        dp[day][last] = Math.max(dp[day][last], max);
                    }
                }
            }
        }
        return dp[grid.length - 1][3];
    }
}
