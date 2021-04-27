package com.senla.hotel.dao;

import com.senla.hotel.entity.Room;

import java.util.List;

public interface IRoomDAO {
    void save(Room room);
    void update(Room room) throws Exception;
    Room getById(String id) throws Exception;
    String getIdByNumber(int number) throws Exception;
    List<Room> getRooms() throws Exception;
}
