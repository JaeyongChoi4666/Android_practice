package com.example.dbrecyclerapp;

import java.io.Serializable;

public class Movie implements Serializable {
    private int id;
    private String title;
    private double point;
    private String director;
    private String actors;
    private int resId;

    public Movie() {
    }

    public Movie(int id, String title, double point, String director, String actors, int resId) {
        this.id = id;
        this.title = title;
        this.point = point;
        this.director = director;
        this.actors = actors;
        this.resId = resId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
