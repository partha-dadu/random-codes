package com.partha.random.recursion;

public class Print1ToNRecursion {

    public static void main(String[] args) {
        Print1ToNRecursion p = new Print1ToNRecursion();
        System.out.println("Printing in order");
        p.print1ToN(1,5);
        System.out.println("Printing in reverse order");
        p.print1ToNDecrement(5);
    }

    public void print1ToN(int current, int target){
        if(current > target)
            return;
        System.out.println("current value "+ current);
        print1ToN(current + 1, target);
    }

    public void print1ToNDecrement(int current){
        if(current < 1)
            return;

        print1ToNDecrement(current-1);
        System.out.println("current value "+ current);
    }
}
