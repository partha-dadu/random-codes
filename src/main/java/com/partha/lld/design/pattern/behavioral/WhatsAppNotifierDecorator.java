package com.partha.lld.design.pattern.behavioral;

public class WhatsAppNotifierDecorator extends BaseNotifierDecorator {

    public WhatsAppNotifierDecorator(INotifier notifier) {
        super(notifier);
    }

    public void sendNotification(String message) {
        super.sendNotification(message);
        System.out.println("sent WhatsApp notification -> "+databaseUtils.getUserPhoneNumber("user"));
    }
}
