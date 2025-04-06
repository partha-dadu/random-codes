package com.partha.lld.design.pattern.behavioral.chainofresponsibility;

public class ValidPasswordHandler extends BaseHandler{
    @Override
    public boolean handle(String username, String password) {
        DatabaseChainUtils databaseChainUtils = new DatabaseChainUtils();
        if(databaseChainUtils.checkValidPassword(username, password)){
            System.out.println("Password found");
            return handleNext(username, password);
        }
        return false;
    }
}
