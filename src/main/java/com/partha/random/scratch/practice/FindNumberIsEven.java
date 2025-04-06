package com.partha.random.scratch.practice;

public class FindNumberIsEven {

    public static void main(String[] args) {
        FindNumberIsEven findNumberIsEven = new FindNumberIsEven();
        System.out.println("Number is "+findNumberIsEven.findNumberIsEven(1001));
    }

    public boolean findNumberIsEven(int num) {
        boolean isEven = true;
        for (int i=1; i<= num; i++) {
            isEven = !isEven;
        }
        return isEven;
    }
}
