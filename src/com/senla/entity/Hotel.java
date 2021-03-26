package com.senla.entity;

import java.util.ArrayList;

public class Hotel {
    private static Hotel hotel = null;
    private final ArrayList<Room> rooms;
    private final ArrayList<Service> services;

    private Hotel(){
        rooms = new ArrayList<>();
        services = new ArrayList<>();
    }

    public static Hotel getHotel(){
        if (hotel == null) {
            hotel = new Hotel();
        }
        return hotel;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Service> getServices() {
        return services;
    }
}
