package com.partha.lld.design.pattern.behavioral.decorator;

public class BaseNotifier implements INotifier{
    private String username;
    private DatabaseUtils databaseUtils;

    public BaseNotifier(String username) {
        this.username = username;
        this.databaseUtils = new DatabaseUtils();
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("sending mail notification -> "+message);
    }

    @Override
    public void getUserProfile() {
        System.out.println("getting user profile for Mail");
    }
}
