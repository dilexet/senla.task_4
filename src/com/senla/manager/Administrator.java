package com.senla.manager;

import com.senla.entity.Client;
import com.senla.entity.Hotel;
import com.senla.entity.Room;
import com.senla.entity.Service;
import com.senla.enums.Status;

public class Administrator {
    private final Hotel hotel;

    public Administrator(Hotel hotel) {
        this.hotel = hotel;
    }

    public String checkInRoom(Client client) throws Exception {
        var room = hotel.getRooms().stream().filter(r -> r.getStatus() == Status.FREE && r.getClient() == null).findFirst();
        if (room.isEmpty()) {
            throw new Exception("No free room");
        } else {
            room.get().setStatus(Status.BUSY);
            room.get().setClient(client);
            return client.getName() + " is checked into room " + room.get().getNumber();
        }
    }

    public String checkOutRoom(int number) throws Exception {
        var room = hotel.getRooms().stream().filter(r -> r.getStatus() == Status.BUSY && r.getNumber() == number).findFirst();
        if (room.isEmpty()) {
            throw new Exception("Room not found");
        } else {
            room.get().setStatus(Status.FREE);
            room.get().setClient(null);
            return "Client was evicted from room " + room.get().getNumber() + ", payable " + room.get().getPrice() + "$";
        }
    }

    public String changeRoomStatus(int number, Status status) throws Exception {
        var room = hotel.getRooms().stream().filter(r -> r.getNumber() == number).findFirst();
        if (room.isEmpty()) {
            throw new Exception("No free room");
        } else {
            room.get().setStatus(status);
            return "The room is under maintenance";
        }
    }

    public String changePriceRoom(int number, double price) throws Exception {
        var room = hotel.getRooms().stream().filter(r -> r.getNumber() == number).findFirst();
        if (room.isEmpty()) {
            throw new Exception("Room not found");
        } else {
            room.get().setPrice(price);
            return "The cost of room number " + room.get().getNumber() + " has been changed to " + room.get().getPrice() + "$";
        }
    }

    public String changePriceService(String serviceName, double price) throws Exception {
        var service = hotel.getServices().stream().filter(r -> r.getServiceName().equals(serviceName)).findFirst();
        if (service.isEmpty()) {
            throw new Exception("Service not found");
        } else {
            service.get().setPrice(price);
            return "The cost of the " + service.get().getServiceName() + " service has been changed to " + service.get().getPrice() + "$";
        }
    }

    public String addRoom(int number, double price) throws Exception {
        var room = hotel.getRooms().stream().filter(r -> r.getNumber() == number).findFirst();
        if (room.isPresent()) {
            throw new Exception("A room with the same number already exists");
        } else {
            hotel.getRooms().add(new Room(number, price));
            return "Room " + number + " added successfully";
        }
    }

    public String addService(String serviceName, double price) throws Exception {
        var service = hotel.getServices().stream().filter(r -> r.getServiceName().equals(serviceName)).findFirst();
        if (service.isPresent()) {
            throw new Exception("A service with this name already exists");
        } else {
            hotel.getServices().add(new Service(serviceName, price));
            return "Service " + serviceName + " added successfully";
        }
    }
}
