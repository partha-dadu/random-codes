package com.partha.lld.design.pattern.creational.abstractfactory;

public class IntelMonitor implements MonitorInterface{
    @Override
    public void assemble() {
        System.out.println("Eizo Monitor assemble");
    }
}
