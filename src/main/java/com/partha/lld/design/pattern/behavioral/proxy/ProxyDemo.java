package com.partha.lld.design.pattern.behavioral.proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeProxyDAO(new EmployeeDAOImpl(), "ADMIN");
        employeeDAO.checkConnection();
        employeeDAO.insertRecord("record");
    }
}
