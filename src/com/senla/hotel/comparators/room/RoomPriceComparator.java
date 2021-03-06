package com.senla.hotel.comparators.room;

import com.senla.hotel.entity.Room;

import java.util.Comparator;

public class RoomPriceComparator implements Comparator<Room> {
    @Override
    public int compare(Room room1, Room room2) {
        return Double.compare(room1.getPrice(), room2.getPrice());
    }
}
