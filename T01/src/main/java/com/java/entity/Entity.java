package com.java.entity;

public class Entity {

    private int CourseID;
    private String CourseName;
    private String Teacher;
    private int Chapter;
    private int Period;
    private int isFee;
    private String Intro;

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String teacher) {
        Teacher = teacher;
    }

    public int getChapter() {
        return Chapter;
    }

    public void setChapter(int chapter) {
        Chapter = chapter;
    }

    public int getPeriod() {
        return Period;
    }

    public void setPeriod(int period) {
        Period = period;
    }

    public int getIsFee() {
        return isFee;
    }

    public void setIsFee(int isFee) {
        this.isFee = isFee;
    }

    public String getIntro() {
        return Intro;
    }

    public void setIntro(String intro) {
        Intro = intro;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "CourseID=" + CourseID +
                ", CourseName='" + CourseName + '\'' +
                ", Teacher='" + Teacher + '\'' +
                ", Chapter=" + Chapter +
                ", Period=" + Period +
                ", isFee=" + isFee +
                ", Intro='" + Intro + '\'' +
                '}';
    }
}
