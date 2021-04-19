package com.senla.hotel.dto;

public class RoomDTO {
    private int number;
    private double price;

    private String clientName;

    public RoomDTO(int number, double price) {
        this.number = number;
        this.price = price;
    }

    @Override
    public String toString() {
        return number + "," + price + "," + clientName + "\n";
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

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

}
