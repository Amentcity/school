package com.java.pojo;

import java.util.Arrays;
import java.util.Map;

public class Student implements Person{
    private int sid;
    private String name;
    private int age;
    private String gender;
    private Double score;
    private String[] hobby;
    private Clazz clazz;
    private Map<String,Teacher> teacherMap;

    public Student() {
    }

    public Student(int sid, String name, String gender, int age) {
        this.sid = sid;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    public Student(int sid, String name, String gender, Double score) {
        this.sid = sid;
        this.name = name;
        this.gender = gender;
        this.score=score;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", score=" + score +
                ", hobby=" + Arrays.toString(hobby) +
                ", clazz=" + clazz +
                ", teacherMap=" + teacherMap +
                '}';
    }
}
