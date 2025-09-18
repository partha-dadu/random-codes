package com.partha.lld.design.pattern.behavioral.decorator;

public class NotifierEmailCore implements INotifier{

    String userName;

    public NotifierEmailCore(String userName){
        this.userName = userName;
    }
    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Email to "+this.getUserName()+" with message: "+message);
    }
}
