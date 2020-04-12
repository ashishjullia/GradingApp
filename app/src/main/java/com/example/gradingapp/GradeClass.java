package com.example.gradingapp;

import java.lang.ref.SoftReference;

public class GradeClass {
    private int id;
    private String firstName;
    private String lastName;
    private String course;
    private String credits;
    private String marks;

    // Default Constructor
    public GradeClass () {}

    // Parameterized Constructor
    public GradeClass (int id, String firstName, String lastName, String course, String credits, String marks) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.credits = credits;
        this.marks = marks;
    }

    // Setters
    public void setGradeId (int id) { this.id = id; }

    public void setGradeFirstName (String firstName) { this.firstName = firstName; }

    public void setGradeLastName (String lastName) { this.lastName = lastName; }

    public void setGradeCourse (String course) { this.course = course; }

    public void setGradeCredits (String credits) { this.credits = credits; }

    public void setGradeMarks (String marks) { this.marks = marks; }

    // Getters
    public int getGradeId () { return id; }

    public String getGradeFirstName () { return firstName; }

    public String getGradeLastName () { return lastName; }

    public String getGradeCourse () { return course; }

    public String getGradeCredits () { return credits; }

    public String getGradeMarks () { return marks; }
}
