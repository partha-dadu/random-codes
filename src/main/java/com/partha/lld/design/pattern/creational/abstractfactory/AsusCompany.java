package com.partha.lld.design.pattern.creational.abstractfactory;

public class AsusCompany implements CompanyInterface{
    @Override
    public GPUInterface createGPU() {
        return new AsusGPU();
    }

    @Override
    public MonitorInterface createMonitor() {
        return new AsusMonitor();
    }
}
