package com.partha.lld.design.pattern.structural.adapter;

public class SchoolStudent implements Student {
        private String name;
        private String rollNumber;
        private int age;
        private String school;
        private String email;


    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getInstitution() {
        return this.getSchool();
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
