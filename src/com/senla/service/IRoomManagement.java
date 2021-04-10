package com.senla.service;

import com.senla.entity.Client;
import com.senla.entity.Room;
import com.senla.enums.Status;

import java.util.Comparator;

public interface IRoomManagement {
    String sort(Comparator<Room> roomComparator) throws Exception;

    String checkInRoom(Client client) throws Exception;

    String checkOutRoom(int number) throws Exception;

    String changeRoomStatus(int number, Status status) throws Exception;

    String changePriceRoom(int number, double price) throws Exception;

    String addRoom(int number, double price) throws Exception;
}
