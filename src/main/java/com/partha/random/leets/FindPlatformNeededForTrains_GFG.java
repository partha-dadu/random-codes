package com.partha.random.leets;

import java.util.Arrays;

public class FindPlatformNeededForTrains_GFG {

    /**
     * Minimum Platforms Required for Given Arrival and Departure Times
     * <p>
     * Input: arr[] = [900, 940, 950, 1100, 1500, 1800], dep[] = [910, 1200, 1120, 1130, 1900, 2000]
     * Output: 3
     * Explanation: There are three trains during the time 9:40 to 12:00. So we need a minimum of 3 platforms.
     **/

    public static void main(String[] args) {
        FindPlatformNeededForTrains_GFG obj = new FindPlatformNeededForTrains_GFG();
        int[] arrivals = {1114, 825, 357, 1415, 54};
        int[] departures = {1740, 1110, 2238, 1535, 2323};
        int result = obj.findPlatforms(arrivals,departures);
        System.out.println(result);
    }

    public int findPlatforms(int[] arr, int[] dep){
        Arrays.sort(arr);
        Arrays.sort(dep);
        int currDeparture = 0;
        int currentPlatform =1;
        int maxPlatform =1;

        for(int currArrival = 1;currArrival < arr.length;currArrival++){
            if(arr[currArrival] <= dep[currDeparture]){
                currentPlatform++;
                maxPlatform = Math.max(currentPlatform,maxPlatform);
            }else {
                while(currArrival >= (currDeparture+1) && arr[currArrival] > dep[currDeparture]){
                        currDeparture++;
                        currentPlatform--;
                }
                currentPlatform++;
            }
        }
        return maxPlatform;
    }

    public int gfgSolution(int[] arr, int[] dep){
        // add your code here
        int n = arr.length;
        int res = 0;

        // Sort the arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        // Pointer to track the departure times
        int j = 0;

        // Tracks the number of platforms needed at any given time
        int cnt = 0;

        // Check for each train
        for (int i = 0; i < n; i++) {

            // Decrement count if other
            // trains have left
            while (j < n && dep[j] < arr[i]) {
                cnt--;
                j++;
            }

            // one platform for current train
            cnt++;

            res = Math.max(res, cnt);
        }

        return res;
    }

    private void sortIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[0], b[0]);
        });
    }
}
