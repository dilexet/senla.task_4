package com.senla.manager;

import com.senla.entity.Client;
import com.senla.entity.Room;
import com.senla.entity.Service;
import com.senla.enums.Status;
import com.senla.service.IRoomManagement;
import com.senla.service.IServiceManagement;

import java.util.Comparator;

public class Administrator {
    private final IRoomManagement roomManagement;
    private final IServiceManagement serviceManagement;

    public Administrator(IRoomManagement roomManagement, IServiceManagement serviceManagement) {
        this.roomManagement = roomManagement;
        this.serviceManagement = serviceManagement;
    }

    public String sortRoom(Comparator<Room> roomComparator) throws Exception {
        return roomManagement.sort(roomComparator);
    }

    public String sortService(Comparator<Service> serviceComparator) throws Exception {
        return serviceManagement.sort(serviceComparator);
    }


    public String checkInRoom(Client client) throws Exception {
        return roomManagement.checkInRoom(client);
    }

    public String checkOutRoom(int number) throws Exception {
        return roomManagement.checkOutRoom(number);
    }

    public String changeRoomStatus(int number, Status status) throws Exception {
        return roomManagement.changeRoomStatus(number, status);
    }

    public String changePriceRoom(int number, double price) throws Exception {
        return roomManagement.changePriceRoom(number, price);
    }

    public String changePriceService(String serviceName, double price) throws Exception {
        return serviceManagement.changePriceService(serviceName, price);
    }

    public String addRoom(int number, double price) throws Exception {
        return roomManagement.addRoom(number, price);
    }

    public String addService(String serviceName, double price) throws Exception {
        return serviceManagement.addService(serviceName, price);
    }
}
