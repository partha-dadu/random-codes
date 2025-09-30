package com.partha.lld.design.pattern.behavioral.facade;

public class FlipkartBooking implements OrderBooking{
    @Override
    public boolean validatePayment() {
        System.out.println("FlipkartBooking::validatePayment()");
        return true;
    }

    @Override
    public void notifyOrder() {
        System.out.println("FlipkartBooking::notifyOrder()");
    }

    @Override
    public boolean checkAvailability() {
        System.out.println("FlipkartBooking::checkAvailability()");
        return true;
    }
}
