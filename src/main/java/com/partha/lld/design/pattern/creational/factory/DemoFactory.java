package com.partha.lld.design.pattern.creational.factory;

public class DemoFactory {
    public static void main(String[] args) {
        Bottle plasticBottle = BottleFactory.createBottle(Bottle.BottleType.PLASTIC_BOTTLE, 1.0);
        Bottle metalBottle = BottleFactory.createBottle(Bottle.BottleType.METAL_BOTTLE, 2.0);
    }
}
