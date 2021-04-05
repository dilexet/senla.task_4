package com.senla.entity;

public class Client {
    private static int id;
    private final String name;

    public Client() {
        id++;
        name = "Client №" + id;
    }

    public Client(String name) {
        id++;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "\nName: " + name;
    }
}
