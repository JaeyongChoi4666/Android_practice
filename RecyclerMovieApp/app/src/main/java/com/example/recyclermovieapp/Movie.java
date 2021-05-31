package com.example.recyclermovieapp;

public class Movie {
    String mvName;
    String openYear;
    String director;
    String actor;
    int poster;

    public Movie() {
    }

    public Movie(String mvName, int poster) {
        this.mvName = mvName;
        this.poster = poster;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getMvName() {
        return mvName;
    }

    public void setMvName(String mvName) {
        this.mvName = mvName;
    }

    public String getOpenYear() {
        return openYear;
    }

    public void setOpenYear(String openYear) {
        this.openYear = openYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
