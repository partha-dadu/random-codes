package com.partha.lld.design.pattern.behavioral.decorator;

public class DatabaseUtils {

    public DatabaseUtils() {

    }

    public String getUserProfile(String username){
        System.out.println("Got UserProfile");
        return "UserProfile";
    }

    public String getUserPhoneNumber(String username){
        System.out.println("Got UserPhoneNumber");
        return "UserPhoneNumber";
    }
}
