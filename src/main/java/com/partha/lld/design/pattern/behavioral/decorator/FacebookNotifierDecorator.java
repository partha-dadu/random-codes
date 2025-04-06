package com.partha.lld.design.pattern.behavioral.decorator;

public class FacebookNotifierDecorator extends BaseNotifierDecorator {

    public FacebookNotifierDecorator(INotifier notifier) {
        super(notifier);
    }

    public void sendNotification(String message) {
        super.sendNotification(message);
        System.out.println("sent Facebook notification -> "+databaseUtils.getUserProfile("user"));
    }
}
