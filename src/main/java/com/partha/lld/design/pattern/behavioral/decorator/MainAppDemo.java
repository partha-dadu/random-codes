package com.partha.lld.design.pattern.behavioral.decorator;

public class MainAppDemo {
    public static void main(String[] args) {
        INotifier notifier = new FaceBookNotifierDecorator(new WhatsAppNotifierDecorator(new NotifierEmailCore("XYZ")));
        notifier.sendNotification("Hello World");
    }
}
