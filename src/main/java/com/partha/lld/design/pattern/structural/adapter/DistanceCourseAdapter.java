package com.partha.lld.design.pattern.structural.adapter;

public class DistanceCourseAdapter implements Student{

    private DistanceCourseStudent distanceCourseStudent;
    public DistanceCourseAdapter(DistanceCourseStudent distanceCourseStudent) {
        this.distanceCourseStudent = distanceCourseStudent;
    }

    @Override
    public String getName() {
        return this.distanceCourseStudent.getName();
    }

    @Override
    public String getRollNumber() {
        return this.distanceCourseStudent.getRegdNumber();
    }

    @Override
    public int getAge() {
        return this.distanceCourseStudent.getAge();
    }

    @Override
    public String getEmail() {
        return this.distanceCourseStudent.getEmail();
    }

    @Override
    public String getInstitution() {
        return this.distanceCourseStudent.getUniversity();
    }
}
