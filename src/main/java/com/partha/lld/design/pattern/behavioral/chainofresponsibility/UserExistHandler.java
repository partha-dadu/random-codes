package com.partha.lld.design.pattern.behavioral.chainofresponsibility;

public class UserExistHandler extends BaseHandler {

    @Override
    public boolean handle(String username, String password) {
        DatabaseChainUtils databaseChainUtils = new DatabaseChainUtils();
        if(databaseChainUtils.checkValidUsername(username)) {
            System.out.println("Username found");
            return handleNext(username, password);
        }
        return false;
    }
}
