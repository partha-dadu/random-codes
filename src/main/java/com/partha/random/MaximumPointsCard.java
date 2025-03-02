package com.partha.random;


/**
 * Input: cardPoints = [1,2,3,4,5,6,1], k = 3
 * Output: 12
 * Explanation: After the first step, your score will always be 1.
 * However, choosing the rightmost card first will maximize your total score.
 * The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
 * */
public class MaximumPointsCard {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,1};
        int k = 3;
        MaximumPointsCard maximumPointsCard = new MaximumPointsCard();
        maximumPointsCard.function(nums,k);
    }

    public void function(int[] cardPoints, int k){
        int maxPoint = 0;
        int pointer = 0;
        int sum = 0;
        while (pointer < k){
            sum = sum + cardPoints[pointer];
            maxPoint = Math.max(sum, maxPoint);
            pointer++;
        }
        for(int i = k-1,j=1; i >=0; i--,j++){
            sum = sum - cardPoints[i] + cardPoints[cardPoints.length - j];
            maxPoint = Math.max(sum, maxPoint);
        }
        System.out.println("answer "+maxPoint);
    }
}
