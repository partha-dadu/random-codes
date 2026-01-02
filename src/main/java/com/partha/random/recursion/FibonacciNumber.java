package com.partha.random.recursion;

public class FibonacciNumber {

    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        System.out.println("Fibonacci number -> "+fibonacciNumber.fibonacci(8));
    }

    public int fibonacci(int n){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        return fibonacci(n-1)+fibonacci(n-2);
    }
}
