package com.trainingit.training.model;

public class Training {

    private String course;

    private Integer subjects;

    private Double price;

    public Training() {
        super();
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getSubjects() {
        return subjects;
    }

    public void setSubjects(Integer subjects) {
        this.subjects = subjects;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
