package com.partha.random.leets;

import java.util.ArrayList;
import java.util.List;

public class TestingArrayList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        for(int i = 0;i < list.size(); i++){
            System.out.println("Addeed "+list.get(i));
        }
        list.remove((Integer) 1);
        for(int i = 0;i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
