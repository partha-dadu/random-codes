package com.partha.lld.design.pattern.creational.builder;

public class SchoolStudent implements Student
{
    private String studentName;
    private String studentID;
    private String studentEmail;
    private int studentAge;
    private String studentGender;
    private String studentSchool;

    public SchoolStudent(StudentBuilder studentBuilder){
        this.studentName = studentBuilder.getStudentName();
        this.studentID = studentBuilder.getStudentID();
        this.studentEmail = studentBuilder.getStudentEmail();
        this.studentAge = studentBuilder.getStudentAge();
        this.studentGender = studentBuilder.getStudentGender();
        this.studentSchool = studentBuilder.getStudentSchool();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentSchool() {
        return studentSchool;
    }

    public void setStudentSchool(String studentSchool) {
        this.studentSchool = studentSchool;
    }

    @Override
    public Student getStudent(String name, String rollNumber, int age) {
        StudentBuilder studentBuilder = new StudentBuilder()
                .setStudentName(name).setStudentID(rollNumber).setStudentAge(age);
        return studentBuilder.build();
    }
}


