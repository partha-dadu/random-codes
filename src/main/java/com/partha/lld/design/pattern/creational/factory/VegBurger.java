package com.partha.lld.design.pattern.creational.factory;

public class VegBurger implements Burger{


    @Override
    public void prepareBurger() {
        System.out.println("Preparing Veg Burger");
    }
}
