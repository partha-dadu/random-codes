package com.partha.lld.design.pattern.behavioral.chainofresponsibility;

public abstract class BaseHandler implements Handler {
    protected BaseHandler nextHandler;


    public BaseHandler setNextHandler(BaseHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public boolean handleNext(String username, String password) {
        if (nextHandler == null) {
            System.out.println("Next handler is null");
            return true;
        }
        System.out.println("Next handler");
        return nextHandler.handle(username, password);
    }

}
