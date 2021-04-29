package com.senla.hotel.dao;

import com.senla.hotel.entity.Room;
import com.senla.hotel.enums.RoomSortingType;

import java.io.IOException;
import java.util.List;

public interface IRoomDAO {
    void saveOrUpdate(Room room) throws Exception;
    Room getById(String id) throws Exception;
    List<Room> getRooms(RoomSortingType roomSortingType) throws Exception;
}
