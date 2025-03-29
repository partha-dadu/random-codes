package com.partha.lld.design.pattern.creational.builder;

public class StudentBuilder {
    private String studentName;
    private String studentID;
    private String studentEmail;
    private int studentAge;
    private String studentGender;

    public String getStudentSchool() {
        return studentSchool;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    private String studentSchool;

    public StudentBuilder setStudentName(String studentName) {
        this.studentName = studentName;
        return this;
    }
    public StudentBuilder setStudentID(String studentID) {
        this.studentID = studentID;
        return this;
    }
    public StudentBuilder setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
        return this;
    }
    public StudentBuilder setStudentAge(int studentAge) {
        this.studentAge = studentAge;
        return this;
    }
    public StudentBuilder setStudentGender(String studentGender) {
        this.studentGender = studentGender;
        return this;
    }
    public StudentBuilder setStudentSchool(String studentSchool) {
        this.studentSchool = studentSchool;
        return this;
    }
    public StudentBuilder build() {
        return this;
    }
}
