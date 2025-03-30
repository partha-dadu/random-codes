package com.partha.lld.design.pattern.structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class DemoAdapterMain {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student schoolStudent = new SchoolStudent();
        Student distanceCourseStudent = new DistanceCourseAdapter(new DistanceCourseStudent());
        students.add(schoolStudent);
        students.add(distanceCourseStudent);
    }
}
