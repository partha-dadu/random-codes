package com.partha.lld.design.pattern.behavioral.facade;

public class FacadeAbstraction {
    private OrderBooking orderBooking;
    FacadeAbstraction(OrderBooking orderBooking) {
        this.orderBooking = orderBooking;
    }
    public void placeOrder(){
        orderBooking.checkAvailability();
        orderBooking.validatePayment();
        orderBooking.notifyOrder();
    }
}
