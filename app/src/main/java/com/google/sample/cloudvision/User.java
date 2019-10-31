package com.google.sample.cloudvision;

public class User {
    private String email;
    private String genre;

    public User(String email, String genre) {
        this.email = email;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public String getEmail() {
        return email;
    }
}