package com.partha.lld.design.pattern.creational.factory;

public class MetalBottle implements Bottle {
    private Double capacity;

    public MetalBottle(Double capacity) {
        this.capacity = capacity;
    }

    @Override
    public Bottle createBottle(Double volume) {
        MetalBottle metalBottle = new MetalBottle(volume);
        System.out.println("Creating metal bottle with volume " + volume);
        return metalBottle;
    }
}
