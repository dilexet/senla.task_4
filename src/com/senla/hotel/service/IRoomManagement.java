package com.senla.hotel.service;

import com.senla.hotel.dto.RoomDTO;
import com.senla.hotel.entity.Client;
import com.senla.hotel.entity.Room;
import com.senla.hotel.enums.Status;

import java.util.Comparator;

public interface IRoomManagement {
    String sort(Comparator<Room> roomComparator) throws Exception;

    String accommodateInRoom(Client client) throws Exception;

    String checkOutRoom(int number) throws Exception;

    String changePriceRoom(RoomDTO roomDTO) throws Exception;

    String addRoom(RoomDTO roomDTO) throws Exception;
}
