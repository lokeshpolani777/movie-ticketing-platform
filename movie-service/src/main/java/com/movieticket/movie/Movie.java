package com.movieticket.movie;

public class Movie {

    private int id;
    private String name;
    private String language;
    private String genre;

    public Movie() {
    }

    public Movie(int id, String name, String language, String genre) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.genre = genre;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
