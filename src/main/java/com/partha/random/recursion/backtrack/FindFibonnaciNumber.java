package com.partha.random.recursion.backtrack;

public class FindFibonnaciNumber {

    public static void main(String[] args) {
        FindFibonnaciNumber findFibonnaciNumber = new FindFibonnaciNumber();
        System.out.println("Fibonnaci number  "+findFibonnaciNumber.findFibonnaciNumber(9));
    }

    public int findFibonnaciNumber(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        return findFibonnaciNumber(n - 1) + findFibonnaciNumber(n - 2);
    }
}
