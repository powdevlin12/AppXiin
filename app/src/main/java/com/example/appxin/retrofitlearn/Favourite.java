package com.example.appxin.retrofitlearn;

public class Favourite {
    private int id;
    private String favourite;

    public Favourite(int id, String favourite) {
        this.id = id;
        this.favourite = favourite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFavourite() {
        return favourite;
    }

    public void setFavourite(String favourite) {
        this.favourite = favourite;
    }
}
