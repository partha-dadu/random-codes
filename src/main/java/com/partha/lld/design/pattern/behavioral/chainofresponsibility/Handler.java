package com.partha.lld.design.pattern.behavioral.chainofresponsibility;


public interface Handler {
    boolean handle(String username, String password);
}
