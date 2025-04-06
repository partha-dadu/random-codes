package com.partha.random.recursion.backtrack;

public class FactorialOfN {

    public static void main(String[] args) {
        FactorialOfN f = new FactorialOfN();
        System.out.println("Parameterised");
        f.factorialOfNParameterised(6,1);
        System.out.println("Functional  ");
        System.out.println(f.factorialOfNFunctional(6));
    }

    public void factorialOfNParameterised(int current, int factorial){
        if(current == 0){
            System.out.println("Factorial of N is "+ factorial);
            return;
        }
        factorialOfNParameterised(current - 1, factorial * current);
    }

    public int factorialOfNFunctional(int current){
        if(current == 0){
            return 1;
        }
        return current * factorialOfNFunctional(current - 1);
    }
}
