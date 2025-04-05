package com.partha.random.recursion.backtrack;

public class Print1ToNReverse {

    public static void main(String[] args) {
        Print1ToNReverse print1ToNReverse = new Print1ToNReverse();
        System.out.println("Printing in Reverse way1");
        print1ToNReverse.print1ToNReversalWay(5);
        System.out.println("Printing in Reverse way 2");
        print1ToNReverse.print1ToNReversalWay2(1);
    }

    public void print1ToNReversalWay(int input){
        if(input < 1){
            return;
        }
        System.out.println("Current value "+ input);
        print1ToNReversalWay(input-1);
        System.out.println("below value "+ input);
    }

    public void print1ToNReversalWay2(int input){
        if(input > 10){
            return;
        }
        print1ToNReversalWay2(input+1);
        System.out.println("Current value "+ input);
    }
}
