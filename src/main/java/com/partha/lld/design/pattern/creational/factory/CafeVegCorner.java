package com.partha.lld.design.pattern.creational.factory;

public class CafeVegCorner extends CafeCorner{
    @Override
    public Burger getBurgerType() {
        return new VegBurger();
    }
}
