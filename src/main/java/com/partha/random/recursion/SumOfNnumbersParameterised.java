package com.partha.random.recursion;

public class SumOfNnumbersParameterised {

    public static void main(String[] args) {
        SumOfNnumbersParameterised sum = new SumOfNnumbersParameterised();
        System.out.println("Parameterised");
        sum.printSumOfNnumberParameterised(6,0);
        System.out.println("Fucntional  ");
        System.out.print(sum.printSumOfNnumberFunctional(6));
    }

    public void printSumOfNnumberParameterised(int current, int sum){
        if(current < 1){
            System.out.println("Sum of N number = "+ sum);
            return;
        }
        printSumOfNnumberParameterised(current-1, sum+current);
    }

    public int printSumOfNnumberFunctional(int current){
        if(current < 1){
            return 0;
        }
        return current + printSumOfNnumberFunctional(current-1);
    }
}
