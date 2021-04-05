package com.senla.comparators.room;

import com.senla.entity.Room;

import java.util.Comparator;

public class RoomStatusComparator implements Comparator<Room> {
    @Override
    public int compare(Room room1, Room room2) {
        return room1.getStatus().compareTo(room2.getStatus());
    }
}
