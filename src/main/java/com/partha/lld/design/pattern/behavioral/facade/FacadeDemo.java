package com.partha.lld.design.pattern.behavioral.facade;

public class FacadeDemo {
    public static void main(String[] args) {
        FacadeAbstraction demo = new FacadeAbstraction(new FlipkartBooking());
        demo.placeOrder();
    }
}
