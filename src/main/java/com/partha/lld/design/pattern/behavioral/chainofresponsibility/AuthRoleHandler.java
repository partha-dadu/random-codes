package com.partha.lld.design.pattern.behavioral.chainofresponsibility;

public class AuthRoleHandler extends BaseHandler{
    @Override
    public boolean handle(String username, String password) {
        DatabaseChainUtils databaseChainUtils = new DatabaseChainUtils();
        if(databaseChainUtils.checkAdminRole(username, password)) {
            System.out.println("Admin role found");
            return handleNext(username, password);
        }
        return false;
    }
}
