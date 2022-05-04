package com.example.respro2;

public class RestarauntModel {
    private String rest_name;
    private int course_rating;
    private int course_image;

    // Constructor
    public RestarauntModel(String rest_name, int course_rating, int course_image) {
        this.rest_name = rest_name;
        this.course_rating = course_rating;
        this.course_image = course_image;
    }

    // Getter and Setter
    public String getrest_name() {
        return rest_name;
    }

    public void setrest_name(String rest_name) {
        this.rest_name = rest_name;
    }

    public int getCourse_rating() {
        return course_rating;
    }

    public void setCourse_rating(int course_rating) {
        this.course_rating = course_rating;
    }

    public int getCourse_image() {
        return course_image;
    }

    public void setCourse_image(int course_image) {
        this.course_image = course_image;
    }
}
