package com.partha.random.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixPrinting_54 {

    public List<Integer> getSpiralTraversalOrder(int[][] matrix){
        int top = 0;
        int bottom = matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        List<Integer> result = new ArrayList<>();
        while(top <= bottom && left <= right){
            for(int i=left; i <= right; i++){
                result.add(matrix[top][i]);
            }
            top++;
            for(int j = top ; j <= bottom; j++){
                result.add(matrix[j][right]);
            }
            right--;
            if(top <= bottom){
                for(int k = right; k >= left; k--){
                    result.add(matrix[bottom][k]);
                }
            }
            bottom--;
            if(left <= right){
                for(int m=bottom; m >= top; m--){
                    result.add(matrix[m][left]);
                }
            }
            left++;
        }
        return result;
    }
}
