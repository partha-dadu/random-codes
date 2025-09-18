package com.partha.lld.design.pattern.behavioral.observer;

public class EmailNotifier implements INotifier{



    @Override
    public void update(NotificationIntent notificationIntent) {
        //fetch all product subscribers from DB
        notificationIntent.getProductName();
        System.out.println("Email Notifier: Notified");
    }
}
