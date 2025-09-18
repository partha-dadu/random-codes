package com.partha.lld.design.pattern.behavioral.decorator;

public class FaceBookNotifierDecorator extends IBaseNotifier{

    public FaceBookNotifierDecorator(INotifier wrapped) {
        super(wrapped);
    }

    @Override
    public void sendNotification(String message) {
        super.sendNotification(message);
        System.out.println("Facebook Notification sent to "+this.getUserName()+" with message: "+message);
    }
}
