package com.senla.hotel.dao;

import com.senla.hotel.entity.Room;

import java.util.List;

public interface IRoomDAO {
    void save(Room room);
    void update(Room room) throws Exception;
    List<Room> getRooms() throws Exception;
}
