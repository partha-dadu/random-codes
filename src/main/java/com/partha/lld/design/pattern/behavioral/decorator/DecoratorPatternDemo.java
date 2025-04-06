package com.partha.lld.design.pattern.behavioral.decorator;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        INotifier iNotifier = new FacebookNotifierDecorator(new WhatsAppNotifierDecorator(new BaseNotifier("Base Mail")));
        iNotifier.sendNotification("Base mail notification");
    }
}
