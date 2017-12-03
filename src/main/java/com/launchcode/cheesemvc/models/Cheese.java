package com.launchcode.cheesemvc.models;

public class Cheese {

    private String name;
    private String description;
    private int id;
    private static int nextId = 1;

    public Cheese() {
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Cheese setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Cheese setDescription(String description) {
        this.description = description;
        return this;
    }
}
