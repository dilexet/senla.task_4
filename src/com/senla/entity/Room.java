package com.senla.entity;

import com.senla.enums.Status;

public class Room {
    private final int number;
    private double price;
    private Status status;
    private Client client;

    public Room(int number, double price) throws Exception {
        this.number = number;
        status = Status.FREE;
        if (price < 0.0) {
            throw new Exception("incorrect price");
        }
        this.price = price;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "\nNumber: " + number +
                "\nPrice: " + price +
                "\nStatus: " + status;
    }
}
