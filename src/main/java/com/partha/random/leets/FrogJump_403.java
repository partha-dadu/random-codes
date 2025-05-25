package com.partha.random.leets;

import com.partha.random.Tuple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FrogJump_403 {
    /**
     * A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
     *
     * Given a list of stones positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
     *
     * If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.
     *
     *
     *
     * Example 1:
     *
     * Input: stones = [0,1,3,5,6,8,12,17]
     * Output: true
     * Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
     * Example 2:
     *
     * Input: stones = [0,1,2,3,4,8,9,11]
     * Output: false
     * Explanation: There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.
     *
     * */

    public static void main(String[] args) {
        FrogJump_403 obj = new FrogJump_403();
        int[] stones = {0,1,3,5,6,8,12,17};
//        boolean result = obj.canCross2(stones, 1, 1);
        Map<Tuple<Integer> , Boolean> map = new HashMap<>();
        int maxIntuitiveK = Integer.MIN_VALUE;
        for (int i = 0; i < stones.length; i++) {
            maxIntuitiveK = Math.max(maxIntuitiveK, stones[i]);
        }
        int[][] intuitiveMemoization = new int[stones.length][maxIntuitiveK + 1];
        for( int[] each : intuitiveMemoization) {
            Arrays.fill(each, -1);
        }
//        boolean result = obj.canCross4(stones,0,1, map);
        boolean result = obj.callCanCross2(stones,0,0);
        System.out.println("result "+ result);
    }

    public boolean canCross1(int[] stones, int previousUnit, int index) {
        if(index == stones.length-1){
            return true;
        }
        int nextDifference = stones[index+1] - stones[index];
        if(nextDifference == previousUnit){
            return canCross1(stones, previousUnit, index+1);
        } else if (nextDifference == previousUnit+1) {
            return canCross1(stones, previousUnit+1, index+1);
        }else if (nextDifference == previousUnit-1) {
            return canCross1(stones, previousUnit-1, index+1);
        }else{
            return false;
        }

    }

    public boolean callCanCross2(int[] stones, int currentIndex,int prevValue) {
        Map<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        return canCross2(stones, currentIndex, prevValue, map);
    }

    public boolean canCross2(int[] stones, int currentIndex,int prevValue,Map<Integer, HashMap<Integer, Integer>> map){
        if(currentIndex == stones.length-1){
            return true;
        }

        if(map.get(currentIndex) != null){
            if(map.get(currentIndex).containsKey(prevValue)){
                return map.get(currentIndex).get(prevValue)==1;
            }
        }

        int currentDifference = stones[currentIndex+1] - stones[currentIndex];
        for(int i = prevValue-1; i <=prevValue+1; i++){
            int j = 1;
            while(j < 3) {
                if (currentIndex+j < stones.length && stones[currentIndex] + i == stones[currentIndex + j]) {
                    boolean result = false;
                    result = canCross2(stones, currentIndex + j, i, map);
                    if (result) {
                        HashMap<Integer, Integer> temp = new HashMap<>();
                        temp.put(stones[currentIndex] + i, 1);
                        map.put(currentIndex,temp);
                        return true;
                    }
                }
                j++;
            }

        }
        return false;
    }

    public boolean canCross3(int[] stones) {
        if (stones.length == 0) {
            return true;
        }

        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>(stones.length);
        map.put(0, new HashSet<Integer>());
        map.get(0).add(1);
        for (int i = 1; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>() );
        }

        for (int i = 0; i < stones.length - 1; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                int reach = step + stone;
                if (reach == stones[stones.length - 1]) {
                    return true;
                }
                HashSet<Integer> set = map.get(reach);
                if (set != null) {
                    set.add(step);
                    if (step - 1 > 0) set.add(step - 1);
                    set.add(step + 1);
                }
            }
        }

        return false;
    }

    public boolean canCross4(int[] stones, int currentIndex, int prevValue, Map<Tuple<Integer>, Boolean> possible) {
        if(currentIndex == stones.length-1){
            return true;
        }
        int[] nextSteps = new int[3];
        Arrays.fill(nextSteps, -1);
        if(currentIndex == 0 && stones[currentIndex+1] == 1){
            nextSteps[0] = 1;
        }
        if(prevValue > 0 && currentIndex > 0){
            nextSteps[0] = prevValue;
            if(prevValue - 1 > 0){
                nextSteps[1] = prevValue - 1;
            }
            nextSteps[2] = prevValue+1;
        }

        for(int each : nextSteps){
            if(each != -1){
                int reach = each + stones[currentIndex];
                int nextStoneIndex = -1;
                for(int i =currentIndex; i < stones.length; i++){
                    if(reach == stones[i]){
                        nextStoneIndex = i;
                    }
                }
                Tuple<Integer> currentPossibleIndex = new Tuple<>();
                currentPossibleIndex.setFirst(nextStoneIndex);
                currentPossibleIndex.setSecond(each);
                if(possible.get(currentPossibleIndex) != null){
                    return possible.get(currentPossibleIndex);
                }
                boolean result = canCross4(stones, nextStoneIndex, each, possible);

                possible.put(currentPossibleIndex, result);
                if(result){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean canCrossIntuitive(int[] stones, int currentIndex, int prevValue, int[][] dp){
        if(currentIndex == stones.length-1){
            return true;
        }
        if(dp[currentIndex][prevValue] != -1){
            return dp[currentIndex][prevValue] == 1;
        }
        boolean firstPath,secondPath,thirdPath;
        firstPath = secondPath=thirdPath=false;
        int j =1;
        while (j <4){
            if(currentIndex+j < stones.length && stones[currentIndex]+prevValue-1 == stones[currentIndex+j]){
                firstPath = canCrossIntuitive(stones, currentIndex+j, prevValue-1, dp);
            }
            j++;
        }
        j=1;
        while (j <4){
            if(currentIndex+j < stones.length && stones[currentIndex]+prevValue == stones[currentIndex+j]){
                secondPath = canCrossIntuitive(stones, currentIndex+j, prevValue, dp);
            }
            j++;
        }
        j=1;
        while (j <4){
            if(currentIndex+j < stones.length && stones[currentIndex]+prevValue+1 == stones[currentIndex+j]){
                thirdPath = canCrossIntuitive(stones, currentIndex+j, prevValue+1, dp);
            }
            j++;
        }
        boolean result =  firstPath | secondPath | thirdPath;
        if(result){
            dp[currentIndex][prevValue] = 1;
        }else {
            dp[currentIndex][prevValue] = 0;
        }
        return dp[currentIndex][prevValue] == 1;
    }

    private boolean canJump(int[] stones, int currentIndex, int prevValue){
        for( int i = prevValue-1; i <= prevValue+1; i++){
            int j=1;
            while (j <4){
                if(currentIndex+j < stones.length && stones[currentIndex]+i == stones[currentIndex+j]){
                    return true;
                }
                j++;
            }
        }
        return false;
    }

}
