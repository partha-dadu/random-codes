package com.partha.lld.design.pattern.behavioral.decorator;

public abstract class IBaseNotifier implements INotifier{
    public INotifier wrapped;

    public IBaseNotifier(INotifier wrapped){
        this.wrapped = wrapped;
    }

    @Override
    public String getUserName() {
        return wrapped.getUserName();
    }

    @Override
    public void sendNotification(String message) {
        this.wrapped.sendNotification(message);
    }

}
