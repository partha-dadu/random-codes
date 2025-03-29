package com.partha.lld.design.pattern.creational.factory;

public interface Bottle {

     Bottle createBottle(Double volume);

     enum BottleType {
        PLASTIC_BOTTLE("PLASTIC"),
        METAL_BOTTLE("METAL");

         private final String material;
         BottleType(String material) {
            this.material = material;
         }
    }
}
