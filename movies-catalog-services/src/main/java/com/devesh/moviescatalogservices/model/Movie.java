package com.devesh.moviescatalogservices.model;

public class Movie {

    private String movieId;
    private String name;
    public Movie(){

    }

    public Movie(String movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }

    public String getMovieId() {
        return movieId;
    }

    public Movie setMovieId(String movieId) {
        this.movieId = movieId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Movie setName(String name) {
        this.name = name;
        return this;
    }
}
