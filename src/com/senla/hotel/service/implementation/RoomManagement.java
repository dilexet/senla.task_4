package com.senla.hotel.service.implementation;

import com.senla.hotel.dao.IRoomDAO;
import com.senla.hotel.entity.Room;
import com.senla.hotel.enums.RoomSortingType;
import com.senla.hotel.enums.Status;
import com.senla.hotel.service.IRoomManagement;

import java.util.List;

public class RoomManagement implements IRoomManagement {
    private final IRoomDAO roomDAO;

    public RoomManagement(IRoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public List<Room> getRooms(RoomSortingType roomSortingType) throws Exception {
        return roomDAO.getRooms(roomSortingType);
    }

    public String accommodateInRoom(String clientId) throws Exception {
        var room = roomDAO.getRooms(RoomSortingType.NONE).stream().filter(r -> r.getStatus() == Status.FREE).findFirst();
        if (room.isEmpty()) {
            return "No free room";
        } else {
            room.get().setStatus(Status.BUSY);
            room.get().setClientId(clientId);
            roomDAO.saveOrUpdate(room.get());
            return  "Room " + room.get().getNumber() + " is busy";
        }
    }

    public String checkOutRoom(int number) throws Exception {
        var room = roomDAO.getRooms(RoomSortingType.NONE).stream().filter(r -> r.getNumber() == number).findFirst();
        if (room.isEmpty()) {
            return "Room not found";
        } else {
            room.get().setStatus(Status.FREE);
            room.get().setClientId(null);
            roomDAO.saveOrUpdate(room.get());
            return "Client was evicted from room " + room.get().getNumber() + ", payable " + room.get().getPrice() + "$";
        }
    }

    public String changePriceRoom(String id, double newPrice) throws Exception {
        var rooms = roomDAO.getById(id);
        if (rooms == null) {
            return "Room not found";
        } else {
            rooms.setPrice(newPrice);
            roomDAO.saveOrUpdate(rooms);
            return "The cost of room number " + rooms.getNumber() + " has been changed to " + rooms.getPrice() + "$";
        }
    }

    public String addRoom(Room room) throws Exception {
        var rooms = roomDAO.getRooms(RoomSortingType.NONE).stream().filter(r -> r.getNumber() == room.getNumber()).findFirst();
        if (rooms.isPresent()) {
            return "A room with the same number already exists";
        } else {
            roomDAO.saveOrUpdate(room);
            return "Room " + room.getNumber() + " added successfully";
        }
    }

    public Room getById(String id) throws Exception {
        return roomDAO.getById(id);
    }
}
