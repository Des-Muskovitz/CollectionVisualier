package com.colvis;

import java.util.Arrays;

public class Student {

    private int id;
    private String name;
    private String address;
    private int[] grades;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", grades=" + Arrays.toString(grades) +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public Student(int id, String name, String address, int[] grades) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.grades = grades;
    }
}
