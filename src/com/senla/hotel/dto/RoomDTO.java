package com.senla.hotel.dto;

import com.senla.hotel.entity.Client;
import com.senla.hotel.enums.Status;

public class RoomDTO {
    private final int number;
    private final double price;
    private final Status status;
    private final Client client;

    public RoomDTO(int number, double price, Status status, Client client) {
        this.number = number;
        this.price = price;
        this.status = status;
        this.client = client;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "number=" + number +
                ", price=" + price +
                ", status=" + status +
                ", client=" + client.getName() +
                '}';
    }
}
