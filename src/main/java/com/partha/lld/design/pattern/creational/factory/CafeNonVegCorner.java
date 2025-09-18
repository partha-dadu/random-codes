package com.partha.lld.design.pattern.creational.factory;

public class CafeNonVegCorner extends CafeCorner{
    @Override
    public Burger getBurgerType() {
        return new ChickenBurger();
    }
}
