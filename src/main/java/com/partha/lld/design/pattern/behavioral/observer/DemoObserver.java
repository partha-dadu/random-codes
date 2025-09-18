package com.partha.lld.design.pattern.behavioral.observer;

public class DemoObserver {
    public static void main(String[] args) {
        OnlineStore onlineStore = new OnlineStore();
        onlineStore.addNotifier(new EmailNotifier());
        onlineStore.addNotifier(new PushNotifier());
        onlineStore.setStock(5);
    }
}
