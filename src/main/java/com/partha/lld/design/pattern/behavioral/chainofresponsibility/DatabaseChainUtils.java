package com.partha.lld.design.pattern.behavioral.chainofresponsibility;

import java.util.HashMap;
import java.util.Map;

public class DatabaseChainUtils {
    public static Map<String, String> users = new HashMap<>();
    static {
        users.put("admin", "admin");
        users.put("user", "user");
    }
    public boolean checkValidPassword(String username, String password) {
        if (users.containsKey(username)) {
            return password.equals(users.get(username));
        }
        return false;
    }

    public boolean checkValidUsername(String username) {
        if (users.containsKey(username)) {
            return true;
        }
        return false;
    }

    public boolean checkAdminRole(String username, String password) {
        if (users.containsKey(username)) {
            return "admin".equals(username);
        }
        return false;
    }
}
