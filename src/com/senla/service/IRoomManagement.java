package com.senla.service;

import com.senla.entity.Client;
import com.senla.entity.Hotel;
import com.senla.entity.Room;
import com.senla.enums.Status;

import java.util.Comparator;

public interface IRoomManagement {
    String sort(Hotel hotel, Comparator<Room> roomComparator);

    String checkInRoom(Hotel hotel, Client client);

    String checkOutRoom(Hotel hotel, int number);

    String changeRoomStatus(Hotel hotel, int number, Status status);

    String changePriceRoom(Hotel hotel, int number, double price) throws Exception;

    String addRoom(Hotel hotel, int number, double price) throws Exception;
}
