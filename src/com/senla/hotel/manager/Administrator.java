package com.senla.hotel.manager;

import com.senla.hotel.dto.RoomDTO;
import com.senla.hotel.dto.ServiceDTO;
import com.senla.hotel.entity.Client;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;
import com.senla.hotel.enums.RoomSortingType;
import com.senla.hotel.enums.ServiceSortingType;
import com.senla.hotel.service.IClientManagement;
import com.senla.hotel.service.IRoomManagement;
import com.senla.hotel.service.IServiceManagement;
import com.senla.hotel.tools.Converter;

import java.util.List;

public class Administrator {
    private final IRoomManagement roomManagement;
    private final IServiceManagement serviceManagement;
    private final IClientManagement clientManagement;

    public Administrator(IRoomManagement roomManagement, IServiceManagement serviceManagement, IClientManagement clientManagement) {
        this.roomManagement = roomManagement;
        this.serviceManagement = serviceManagement;
        this.clientManagement = clientManagement;
    }

    public List<Room> getRooms(RoomSortingType roomSortingType) throws Exception {
        return roomManagement.getRooms(roomSortingType);
    }

    public List<Service> sortServices(ServiceSortingType serviceSortingType) throws Exception {
        return serviceManagement.getServices(serviceSortingType);
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

    public RoomDTO getRoomDetails(String id) throws Exception {
        var room = roomManagement.getById(id);
        var client = clientManagement.getById(room.getClientId());

        return Converter.convertToDTO(room, client);
    }

    public ServiceDTO getServiceDetails(String id) throws Exception {
        var service = serviceManagement.getById(id);
        return Converter.convertToDTO(service);
    }
}
