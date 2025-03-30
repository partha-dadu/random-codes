package com.partha.lld.design.pattern.behavioral;

public abstract class BaseNotifierDecorator implements INotifier {

    private INotifier notifier;
    DatabaseUtils databaseUtils;
    public BaseNotifierDecorator(INotifier notifier) {
        this.notifier = notifier;
        databaseUtils = new DatabaseUtils();
    }
    public void sendNotification(String message) {
        notifier.sendNotification(message);
    }
    public void getUserProfile() {
        System.out.println("getUserProfile with some logic");
    }
}
