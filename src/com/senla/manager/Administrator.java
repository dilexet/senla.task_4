package com.senla.manager;

import com.senla.entity.Client;
import com.senla.entity.Hotel;
import com.senla.enums.Status;
import com.senla.service.RoomManagement;
import com.senla.service.ServiceManagement;

public class Administrator {
    private final Hotel hotel;
    private final RoomManagement roomManagement;
    private final ServiceManagement serviceManagement;

    // TODO: переделать под интерфейсы
    public Administrator(Hotel hotel, RoomManagement roomManagement, ServiceManagement serviceManagement) {
        this.hotel = hotel;
        this.roomManagement = roomManagement;
        this.serviceManagement = serviceManagement;
    }

    // TODO: добавить сортировки

    public String checkInRoom(Client client) {
        return roomManagement.checkInRoom(hotel, client);
    }

    public String checkOutRoom(int number) {
        return roomManagement.checkOutRoom(hotel, number);
    }

    public String changeRoomStatus(int number, Status status) {
        return roomManagement.changeRoomStatus(hotel, number, status);
    }

    public String changePriceRoom(int number, double price) throws Exception {
        return roomManagement.changePriceRoom(hotel, number, price);
    }

    public String changePriceService(String serviceName, double price) throws Exception {
        return serviceManagement.changePriceService(hotel, serviceName, price);
    }

    public String addRoom(int number, double price) throws Exception {
        return roomManagement.addRoom(hotel, number, price);
    }

    public String addService(String serviceName, double price) throws Exception {
       return serviceManagement.addService(hotel, serviceName, price);
    }
}
