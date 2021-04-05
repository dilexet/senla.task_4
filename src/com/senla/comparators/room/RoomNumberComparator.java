package com.senla.comparators.room;

import com.senla.entity.Room;

import java.util.Comparator;

public class RoomNumberComparator implements Comparator<Room> {
    @Override
    public int compare(Room room1, Room room2) {
        return Integer.compare(room1.getNumber(), room2.getNumber());
    }
}
