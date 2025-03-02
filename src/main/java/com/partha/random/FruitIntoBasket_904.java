package com.partha.random;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasket_904 {

    /**
     * Input: fruits = [1,2,3,2,2]
     * Output: 4
     * Explanation: We can pick from trees [2,3,2,2].
     * If we had started at the first tree, we would only pick from trees [1,2].
     * */
    public static void main(String[] args) {
        FruitIntoBasket_904 fruitIntoBasket904 = new FruitIntoBasket_904();
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        int result = fruitIntoBasket904.getFruitsIntoBasket(fruits, 2);
        System.out.println("Results "+result);
    }

    public int getFruitsIntoBasket(int[] fruits, int baskets){
        int l=0;
        int r=0;
        int maxFruits = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(r < fruits.length){
            if(map.get(fruits[r]) != null){
                int freq = map.get(fruits[r]);
                int newFreq = freq+1;
                map.put(fruits[r], newFreq);
            }else{
                map.put(fruits[r], 1);
            }
            if(map.keySet().size() > baskets){
                int freq = map.get(fruits[l]);
                freq--;
                if(freq == 0){
                    map.remove(fruits[l]);
                }else {
                    map.put(fruits[l], freq);
                }
                l++;
            }
            if(map.keySet().size() <= baskets){

                maxFruits = Math.max(maxFruits, r - l + 1);
            }


            r++;
        }
        return maxFruits;
    }

}
