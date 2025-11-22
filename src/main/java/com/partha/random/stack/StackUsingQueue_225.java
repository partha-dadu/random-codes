package com.partha.random.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackUsingQueue_225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());

    }
}

class MyStack {

    Queue<Integer> q1 ;


    public MyStack() {
        q1 = new LinkedList<>();

    }

    public void push(int x) {
        if(q1.size() == 0){
            q1.add(x);
        }else{
            q1.add(x);
            for(int i =1; i < q1.size(); i++ ){
                q1.add(q1.poll());
            }
        }

    }

    public int pop() {
        if(q1.size() == 0)
            throw new RuntimeException();

        return q1.poll();
    }

    public int top() {
        if(q1.size() == 0)
            throw new RuntimeException();

        return q1.peek();
    }

    public boolean empty() {
        return q1.size() == 0;
    }
}