package com.example.myapplication;

public class Student {
    String id;
    String name;
    String course;
    String fee;
    String titles;

    public Student() {
        this.id = id;
        this.name = name;
        this.course = course;
        this.fee = fee;
        this.titles = titles;
    }

    public String getId() {return id;}

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }


}
