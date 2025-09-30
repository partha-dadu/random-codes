package com.partha.lld.design.pattern.behavioral.proxy;

public class EmployeeDAOImpl implements EmployeeDAO {

    // create connection for DB

    public void checkConnection(){
        System.out.println("Checking connection...");
    }

    public void insertRecord(String record){
        System.out.println("Inserting record...");
    }

    public void fetchRecord(String id){
        System.out.println("Fetching record...");
    }

    public void deleteRecord(String id){
        System.out.println("Deleting record...");
    }
}
