package com.partha.lld.design.pattern.creational.abstractfactory;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        CompanyInterface asusCompany = new AsusCompany();
        MonitorInterface asusMonitor = asusCompany.createMonitor();
        asusMonitor.assemble();
        GPUInterface asusGPU = asusCompany.createGPU();
        asusGPU.assemble();

    }
}
