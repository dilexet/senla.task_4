package com.senla.app;

import com.senla.entity.Client;
import com.senla.entity.Hotel;
import com.senla.enums.Status;
import com.senla.manager.Administrator;

public class Main {

    public static void main(String[] args) {
        try {
            Administrator administrator = new Administrator(Hotel.getHotel());

            System.out.println(administrator.addRoom(666, 333));
            System.out.println(administrator.addService("Мини-бар", 228));
            System.out.println(administrator.changePriceRoom(666, 345));
            System.out.println(administrator.changePriceService("Мини-бар", 822));
            System.out.println(administrator.changeRoomStatus(666, Status.REPAIRED));
            System.out.println(administrator.changeRoomStatus(666, Status.FREE));
            System.out.println(administrator.checkInRoom(new Client()));
            System.out.println(administrator.checkOutRoom(666));
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
