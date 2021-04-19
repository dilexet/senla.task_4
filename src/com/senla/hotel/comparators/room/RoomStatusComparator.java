package com.senla.hotel.comparators.room;

import com.senla.hotel.entity.Room;

import java.util.Comparator;

public class RoomStatusComparator implements Comparator<Room> {
    @Override
    public int compare(Room room1, Room room2) {
        return room1.getStatus().compareTo(room2.getStatus());
    }
}
