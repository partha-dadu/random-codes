package com.partha.lld.design.pattern.creational.factory;

public class PlasticBottle implements Bottle {

    private Double volume = null;

    public PlasticBottle(Double volume) {
        this.volume = volume;
    }
    @Override
    public Bottle createBottle(Double volume) {
        PlasticBottle plasticBottle = new PlasticBottle(volume);
        System.out.println("Plasis Bottle created with volume " + volume);
        return plasticBottle;
    }
}
