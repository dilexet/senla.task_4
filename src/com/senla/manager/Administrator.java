package com.senla.manager;

import com.senla.entity.Hotel;
import com.senla.service.IHotelService;

import java.util.ArrayList;

public class Administrator {
    private final Hotel hotel;
    private final IHotelService hotelService;

    public Administrator(Hotel hotel, IHotelService hotelService) {
        this.hotel = hotel;
        this.hotelService = hotelService;
    }

    public String processCommand(int command) throws Exception {
        return switch (command) {
            case 0 -> "Exit";
            case 1 -> accommodateRoom();
            case 2 -> checkOutRoom();
            case 3 -> changeRoomStatus();
            case 4 -> changePriceRoom();
            case 5 -> changePriceService();
            case 6 -> addRoom();
            case 7 -> addService();
            default -> throw new Exception("incorrect input");
        };
    }

    // case 1
    private String accommodateRoom(){
        return null;
    }
    // case 2
    private String checkOutRoom(){
        return null;
    }
    // case 3
    private String changeRoomStatus(){
        return null;
    }
    // case 4
    private String changePriceRoom(){
        return null;
    }
    // case 5
    private String changePriceService(){
        return null;
    }
    // case 6
    private String addRoom(){
        return null;
    }
    // case 7
    private String addService(){
        return null;
    }
}
