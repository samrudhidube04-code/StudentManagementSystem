package com.sms.model;

public class Student {
    private int id;
    private String name;
    private String roll;
    private String dob;
    private String email;
    private String course;

    // Default constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(int id, String name, String roll, String dob, String email, String course) {
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.dob = dob;
        this.email = email;
        this.course = course;
    }

    // Getters and Setters
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

    public String getRoll() {
        return roll;
    }
    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
}
