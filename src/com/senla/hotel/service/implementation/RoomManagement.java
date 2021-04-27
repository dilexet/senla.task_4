package com.senla.hotel.service.implementation;

import com.senla.hotel.dao.IRoomDAO;
import com.senla.hotel.entity.Client;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;
import com.senla.hotel.enums.Status;
import com.senla.hotel.service.IRoomManagement;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.UUID;

public class RoomManagement implements IRoomManagement {
    private final IRoomDAO roomDAO;

    public RoomManagement(IRoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public TreeSet<Room> getRooms(Comparator<Room> roomComparator) throws Exception {
        TreeSet<Room> roomsSorted = new TreeSet<>(roomComparator);
        roomsSorted.addAll(roomDAO.getRooms());
        return roomsSorted;
    }

    public List<Room> getRooms() throws Exception {
        return roomDAO.getRooms();
    }

    public String accommodateInRoom(String clientId) throws Exception {
        var room = roomDAO.getRooms().stream().filter(r -> r.getStatus() == Status.FREE).findFirst();
        if (room.isEmpty()) {
            return "No free room";
        } else {
            room.get().setStatus(Status.BUSY);
            room.get().setClientId(clientId);
            roomDAO.update(room.get());
            return  "Room " + room.get().getNumber() + " is busy";
        }
    }

    public String checkOutRoom(int number) throws Exception {
        var room = roomDAO.getRooms().stream().filter(r -> r.getNumber() == number).findFirst();
        if (room.isEmpty()) {
            return "Room not found";
        } else {
            room.get().setStatus(Status.FREE);
            room.get().setClientId(null);
            roomDAO.update(room.get());
            return "Client was evicted from room " + room.get().getNumber() + ", payable " + room.get().getPrice() + "$";
        }
    }

    public String changePriceRoom(String id, double newPrice) throws Exception {
        var rooms = roomDAO.getRooms().stream().filter(r -> r.getId().equals(id)).findFirst();
        if (rooms.isEmpty()) {
            return "Room not found";
        } else {
            rooms.get().setPrice(newPrice);
            roomDAO.update(rooms.get());
            return "The cost of room number " + rooms.get().getNumber() + " has been changed to " + rooms.get().getPrice() + "$";
        }
    }

    public String addRoom(Room room) throws Exception {
        var rooms = roomDAO.getRooms().stream().filter(r -> r.getNumber() == room.getNumber()).findFirst();
        if (rooms.isPresent()) {
            return "A room with the same number already exists";
        } else {
            roomDAO.save(room);
            return "Room " + room.getNumber() + " added successfully";
        }
    }
}
