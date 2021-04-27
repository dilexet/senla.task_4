package com.senla.hotel.manager;

import com.senla.hotel.dao.IClientFileDAO;
import com.senla.hotel.entity.Client;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;
import com.senla.hotel.service.IClientManagement;
import com.senla.hotel.service.IRoomManagement;
import com.senla.hotel.service.IServiceManagement;

import java.util.Comparator;
import java.util.TreeSet;

public class Administrator {
    private final IRoomManagement roomManagement;
    private final IServiceManagement serviceManagement;
    private final IClientManagement clientManagement;

    public Administrator(IRoomManagement roomManagement, IServiceManagement serviceManagement, IClientManagement clientManagement) {
        this.roomManagement = roomManagement;
        this.serviceManagement = serviceManagement;
        this.clientManagement = clientManagement;
    }

    public TreeSet<Room> getRooms(Comparator<Room> roomComparator) throws Exception {
        return roomManagement.getRooms(roomComparator);
    }

    public TreeSet<Service> sortService(Comparator<Service> serviceComparator) throws Exception {
        return serviceManagement.sort(serviceComparator);
    }

    public String accommodateInRoom(Client client) throws Exception {
        clientManagement.addClient(client);
        return roomManagement.accommodateInRoom(client.getId());
    }

    public String checkOutRoom(int number) throws Exception {
        return roomManagement.checkOutRoom(number);
    }

    public String changePriceRoom(Room room) throws Exception {
        return roomManagement.changePriceRoom(room.getId(), room.getPrice());
    }

    public String changePriceService(Service service) throws Exception {
        return serviceManagement.changePriceService(service.getId(), service.getPrice());
    }

    public String addRoom(Room room) throws Exception {
        return roomManagement.addRoom(room);
    }

    public String addService(Service service) throws Exception {
        return serviceManagement.addService(service);
    }
}
