package com.partha.lld.design.pattern.creational.factory;

public abstract class CafeCorner {

    public void orderBurger(){
        Burger burger = getBurgerType();
        System.out.println("Taken your order");
        burger.prepareBurger();

    }

    public abstract Burger getBurgerType();

}
