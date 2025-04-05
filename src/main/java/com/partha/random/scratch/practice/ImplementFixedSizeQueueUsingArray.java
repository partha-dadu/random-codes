package com.partha.random.scratch.practice;

public class ImplementFixedSizeQueueUsingArray {
    private int[] queue;
    private int size;
    private int capacity;

    public ImplementFixedSizeQueueUsingArray(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.size = 0;
    }

    public void enqueue(int value) {
        if(isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        queue[size] = value;
        size++;
    }

    public int dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = queue[0];
        for(int i = 1; i < size; i++) {
            queue[i - 1] = queue[i];
        }
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int getSize() {
        return size;
    }

}
