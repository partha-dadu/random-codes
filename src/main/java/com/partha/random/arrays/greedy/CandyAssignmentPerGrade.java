package com.partha.random.arrays.greedy;

public class CandyAssignmentPerGrade {

    public static void main(String[] args) {
        CandyAssignmentPerGrade test = new CandyAssignmentPerGrade();
        int[] ratings = {1,0,2};
        int result = test.candy(ratings);
        System.out.println(result);
    }

    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        for(int i = 0; i < ratings.length; i++){
            if( i == 0){
                left[i] = 1;
            }else{
                if(ratings[i] >  ratings[i-1]){
                    left[i] = left[i-1] + 1;
                }else{
                    left[i] = 1;
                }
            }

        }
        for(int i = ratings.length-1; i >= 0; i--){
            if(i == ratings.length-1){
                right[i] = 1;
            }else{
                if(ratings[i] > ratings[i+1]){
                    right[i] = right[i+1] + 1;
                }
                else{
                    right[i] = 1;
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < ratings.length; i++){
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }
}
