package com.senla.dataaccessobject;

import com.senla.enums.Status;

public class RoomDTO {
    private int id;
    private int number;
    private double price;
    private Status status;
    private String clientName;

    @Override
    public String toString() {
        return "\n" + id + "," + number + "," + price + "," + clientName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public String getClientName() {
        return clientName;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
