package com.senla.hotel.service;

import com.senla.hotel.entity.Room;
import com.senla.hotel.enums.RoomSortingType;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public interface IRoomManagement {
    List<Room> getRooms(RoomSortingType roomSortingType) throws Exception;

    String accommodateInRoom(String clientId) throws Exception;

    String checkOutRoom(int number) throws Exception;

    String changePriceRoom(String id, double newPrice) throws Exception;

    String addRoom(Room room) throws Exception;

    Room getById(String id) throws Exception;
}
