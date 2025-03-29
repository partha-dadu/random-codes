package com.partha.lld.design.pattern.creational.factory;

public class BottleFactory {
    public static Bottle createBottle(Bottle.BottleType bottleType, Double volume) {
        Bottle bottle = null;
        switch (bottleType) {
            case PLASTIC_BOTTLE:
                bottle  = new PlasticBottle(volume).createBottle(volume);
                break;
            case METAL_BOTTLE:
                bottle  = new MetalBottle(volume).createBottle(volume);
                break;
            default:
                throw new IllegalArgumentException("Invalid bottle type: " + bottleType);
        }
        return bottle;
    }
}
