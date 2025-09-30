package com.partha.lld.design.pattern.behavioral.proxy;

public interface EmployeeDAO {
    void checkConnection();
    void fetchRecord(String id);
    void insertRecord(String record);
    void deleteRecord(String id);
}
