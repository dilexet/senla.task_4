package com.senla.entity;

public class Client {
    private final String name;
    private static int id;
    public Client(){
        id++;
        name = "Client №" + id;
    }

    public String getName() {
        return name;
    }
}
