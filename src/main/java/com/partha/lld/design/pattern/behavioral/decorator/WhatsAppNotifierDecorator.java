package com.partha.lld.design.pattern.behavioral.decorator;

public class WhatsAppNotifierDecorator extends IBaseNotifier{

    public WhatsAppNotifierDecorator(INotifier notifier) {
        super(notifier);

    }

    @Override
    public void sendNotification(String message) {
        super.sendNotification(message);
        System.out.println("WhatsApp Notification sent to "+this.getUserName()+" with message: "+message);
    }
}
