package com.partha.lld.design.pattern.creational.factory;

public class CafeCornerFactory {

    public static CafeCorner createCafeCorner(String cornerType) {

        switch (cornerType) {
            case "Chicken":
                return new CafeNonVegCorner();
            case "Veg":
                return new CafeVegCorner();
            default:
                throw new RuntimeException();
        }
    }
}
