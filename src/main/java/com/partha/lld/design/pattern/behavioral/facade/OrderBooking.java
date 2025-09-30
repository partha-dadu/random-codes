package com.partha.lld.design.pattern.behavioral.facade;

public interface OrderBooking {
     boolean validatePayment();
     void notifyOrder();
     boolean checkAvailability();
}
