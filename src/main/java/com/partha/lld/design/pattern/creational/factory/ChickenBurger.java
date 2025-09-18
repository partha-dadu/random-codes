package com.partha.lld.design.pattern.creational.factory;

public class ChickenBurger implements Burger{

    @Override
    public void prepareBurger() {
        System.out.println("Preparing Chicken Burger");
    }
}
