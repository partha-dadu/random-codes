package com.partha.lld.design.pattern.creational.builder;

public class DemoBuilderMain {
    public static void main(String[] args) {
        StudentBuilder studentBuilder = new StudentBuilder();
        studentBuilder.setStudentAge(15).setStudentName("John Doe").setStudentID("12345")
                .setStudentEmail("john@doe.com").setStudentGender("male");
        Student student = studentBuilder.build();
    }
}
