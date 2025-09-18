package com.partha.lld.design.pattern.creational.abstractfactory;

public class AsusGPU implements GPUInterface{
    @Override
    public void assemble() {
        System.out.println("AsusGPU assemble");
    }
}
