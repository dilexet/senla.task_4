package com.senla.service;

import com.senla.entity.Client;
import com.senla.entity.Hotel;
import com.senla.entity.Room;
import com.senla.enums.Status;
import com.senla.filetools.IFileStreamReader;
import com.senla.filetools.IFileStreamWriter;
import com.senla.filetools.IParserCSV;

public class RoomManagement {
    private final IParserCSV parserCSV;
    private final IFileStreamWriter fileStreamWriter;
    private final IFileStreamReader fileStreamReader;

    public RoomManagement(IParserCSV parserCSV, IFileStreamWriter fileStreamWriter, IFileStreamReader fileStreamReader) {
        this.parserCSV = parserCSV;
        this.fileStreamWriter = fileStreamWriter;
        this.fileStreamReader = fileStreamReader;
    }

    public String checkInRoom(Hotel hotel, Client client) {
        var room = hotel.getRooms().stream().filter(r -> r.getStatus() == Status.FREE && r.getClient() == null).findFirst();
        if (room.isEmpty()) {
            return "No free room";
        } else {
            room.get().setStatus(Status.BUSY);
            room.get().setClient(client);
            return client.getName() + " is checked into room " + room.get().getNumber();
        }
    }

    public String checkOutRoom(Hotel hotel, int number) {
        var room = hotel.getRooms().stream().filter(r -> r.getStatus() == Status.BUSY && r.getNumber() == number).findFirst();
        if (room.isEmpty()) {
            return "Room not found";
        } else {
            room.get().setStatus(Status.FREE);
            room.get().setClient(null);
            return "Client was evicted from room " + room.get().getNumber() + ", payable " + room.get().getPrice() + "$";
        }
    }

    public String changeRoomStatus(Hotel hotel, int number, Status status) {
        var room = hotel.getRooms().stream().filter(r -> r.getNumber() == number).findFirst();
        if (room.isEmpty()) {
            return "No free room";
        } else {
            room.get().setStatus(status);
            return "The room is under maintenance";
        }
    }

    public String changePriceRoom(Hotel hotel, int number, double price) throws Exception {
        var room = hotel.getRooms().stream().filter(r -> r.getNumber() == number).findFirst();
        if (room.isEmpty()) {
            return "Room not found";
        } else {
            room.get().setPrice(price);
            return "The cost of room number " + room.get().getNumber() + " has been changed to " + room.get().getPrice() + "$";
        }
    }

    public String addRoom(Hotel hotel, int number, double price) throws Exception {
        var room = hotel.getRooms().stream().filter(r -> r.getNumber() == number).findFirst();
        if (room.isPresent()) {
            return "A room with the same number already exists";
        } else {
            hotel.getRooms().add(new Room(number, price));
            return "Room " + number + " added successfully";
        }
    }
}
