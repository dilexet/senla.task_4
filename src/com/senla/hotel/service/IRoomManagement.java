package com.senla.hotel.service;

import com.senla.hotel.entity.Client;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public interface IRoomManagement {
    TreeSet<Room> getRooms(Comparator<Room> roomComparator) throws Exception;
    List<Room> getRooms() throws Exception;

    String accommodateInRoom(String clientId) throws Exception;

    String checkOutRoom(int number) throws Exception;

    String changePriceRoom(String id, double newPrice) throws Exception;

    String addRoom(Room room) throws Exception;
}
