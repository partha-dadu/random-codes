package com.partha.lld.design.pattern.behavioral.chainofresponsibility;

public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        BaseHandler handler = new UserExistHandler();
                handler.setNextHandler(new AuthRoleHandler())
                .setNextHandler(new ValidPasswordHandler());
        handler.handle("admin", "admin");
    }
}
