package com.partha.lld.design.pattern.behavioral.proxy;

public class EmployeeProxyDAO implements EmployeeDAO{
    EmployeeDAO employeeDAOImpl;
    String userRole;
    public EmployeeProxyDAO(EmployeeDAO employeeDAO, String userRole){
        super();
        this.employeeDAOImpl = employeeDAO;
        this.userRole = userRole;

    }


    @Override
    public void checkConnection() {
        employeeDAOImpl.checkConnection();
    }

    @Override
    public void fetchRecord(String id) {
        if("USER".equals(userRole)){
            employeeDAOImpl.fetchRecord(id);
        }else {
            System.out.println("Invalid user role");
        }
    }

    @Override
    public void insertRecord(String record) {
        if("ADMIN".equals(userRole)){
            employeeDAOImpl.insertRecord(record);
        }else{
            System.out.println("Invalid user role");
        }
    }

    @Override
    public void deleteRecord(String id) {
        if("ADMIN".equals(userRole)){
            employeeDAOImpl.deleteRecord(id);
        }else{
            System.out.println("Invalid user role");
        }
    }
}
