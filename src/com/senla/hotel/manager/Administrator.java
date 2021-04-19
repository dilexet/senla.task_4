package com.senla.hotel.manager;

import com.senla.hotel.dto.RoomDTO;
import com.senla.hotel.dto.ServiceDTO;
import com.senla.hotel.entity.Client;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;
import com.senla.hotel.enums.Status;
import com.senla.hotel.service.IRoomManagement;
import com.senla.hotel.service.IServiceManagement;

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

    public String changePriceRoom(RoomDTO roomDTO) throws Exception {
        return roomManagement.changePriceRoom(roomDTO);
    }

    public String changePriceService(ServiceDTO serviceDTO) throws Exception {
        return serviceManagement.changePriceService(serviceDTO);
    }

    public String addRoom(RoomDTO roomDTO) throws Exception {
        return roomManagement.addRoom(roomDTO);
    }

    public String addService(ServiceDTO serviceDTO) throws Exception {
        return serviceManagement.addService(serviceDTO);
    }
}
