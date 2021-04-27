package com.senla.hotel.entity;

import com.senla.hotel.enums.Status;

public class Room {
    private String id;
    private final int number;
    private double price;
    private Status status;
    private String clientId;

    public Room(int number, double price) throws Exception {
        this.number = number;
        status = Status.FREE;
        if (price < 0.0) {
            throw new Exception("incorrect price");
        }
        this.price = price;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws Exception {
        if (price < 0.0) {
            throw new Exception("incorrect price");
        }
        this.price = price;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }
}
