package com.partha.lld.design.pattern.creational.abstractfactory;

public class IntelGPU implements GPUInterface{
    @Override
    public void assemble() {
        System.out.println("Intel GPU assemble");
    }
}
