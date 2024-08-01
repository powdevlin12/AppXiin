package com.example.appxin.retrofitlearn;

import java.util.List;

public class User {
    private int id;
    private String name;
    private boolean isActive;
    private Job job;

    public User(int id, String name, boolean isActive, Job job, List<Favourite> favourite) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.job = job;
        this.favourite = favourite;
    }

    private List<Favourite> favourite;

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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public List<Favourite> getFavourite() {
        return favourite;
    }

    public void setFavourite(List<Favourite> favourite) {
        this.favourite = favourite;
    }
}
