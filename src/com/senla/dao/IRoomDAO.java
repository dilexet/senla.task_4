package com.senla.dao;

import com.senla.entity.Room;

import java.util.List;

public interface IRoomDAO {
    void save(Room room);
    void update(Room room) throws Exception;
    List<Room> getRooms() throws Exception;
}
