package com.partha.lld.design.pattern.creational.factory;

public class CafeCornerDemo {

    public static void main(String[] args) {
        CafeCorner cafeCorner = CafeCornerFactory.createCafeCorner("Veg");
        cafeCorner.orderBurger();
    }
}
