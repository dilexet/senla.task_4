package com.senla.hotel.entity;

public class Client {
    private String id;
    private final String name;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        if (name == null) {
            return "";
        }
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
