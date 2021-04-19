package com.senla.hotel.service.implementation;

import com.senla.hotel.dao.IRoomDAO;
import com.senla.hotel.dto.RoomDTO;
import com.senla.hotel.entity.Client;
import com.senla.hotel.entity.Room;
import com.senla.hotel.enums.Status;
import com.senla.hotel.service.IRoomManagement;

import java.util.Comparator;
import java.util.TreeSet;

public class RoomManagement implements IRoomManagement {
    private final IRoomDAO roomDAO;

    public RoomManagement(IRoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public String sort(Comparator<Room> roomComparator) throws Exception {
        TreeSet<Room> roomsSorted = new TreeSet<>(roomComparator);
        roomsSorted.addAll(roomDAO.getRooms());
        return roomsSorted.toString();
    }

    public String checkInRoom(Client client) throws Exception {
        var room = roomDAO.getRooms().stream().filter(r -> r.getStatus() == Status.FREE).findFirst();
        if (room.isEmpty()) {
            return "No free room";
        } else {
            room.get().setStatus(Status.BUSY);
            room.get().setClient(client);
            roomDAO.update(room.get());
            return client.getName() + " is checked into room " + room.get().getNumber();
        }
    }

    public String checkOutRoom(int number) throws Exception {
        var room = roomDAO.getRooms().stream().filter(r -> r.getNumber() == number).findFirst();
        if (room.isEmpty()) {
            return "Room not found";
        } else {
            room.get().setStatus(Status.FREE);
            room.get().setClient(null);
            roomDAO.update(room.get());
            return "Client was evicted from room " + room.get().getNumber() + ", payable " + room.get().getPrice() + "$";
        }
    }

    public String changeRoomStatus(int number, Status status) throws Exception {
        var room = roomDAO.getRooms().stream().filter(r -> r.getNumber() == number).findFirst();
        if (room.isEmpty()) {
            return "No free room";
        } else {
            room.get().setStatus(status);
            roomDAO.update(room.get());
            return "The room is under maintenance";
        }
    }

    public String changePriceRoom(RoomDTO roomDTO) throws Exception {
        var room = roomDAO.getRooms().stream().filter(r -> r.getNumber() == roomDTO.getNumber()).findFirst();
        if (room.isEmpty()) {
            return "Room not found";
        } else {
            room.get().setPrice(roomDTO.getPrice());
            roomDAO.update(room.get());
            return "The cost of room number " + room.get().getNumber() + " has been changed to " + room.get().getPrice() + "$";
        }
    }

    public String addRoom(RoomDTO roomDTO) throws Exception {
        var room = roomDAO.getRooms().stream().filter(r -> r.getNumber() == roomDTO.getNumber()).findFirst();
        if (room.isPresent()) {
            return "A room with the same number already exists";
        } else {
            roomDAO.save(new Room(roomDTO.getNumber(), roomDTO.getPrice()));
            return "Room " + roomDTO.getNumber() + " added successfully";
        }
    }
}
