package com.senla.hotel.tools;

import com.senla.hotel.dto.RoomDTO;
import com.senla.hotel.dto.ServiceDTO;
import com.senla.hotel.entity.Client;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;
import com.senla.hotel.enums.Status;

public class ConvertDTO {
    public static Room convertToRoom(RoomDTO roomDTO) throws Exception {
        Room room = new Room(roomDTO.getNumber(), roomDTO.getPrice());
        room.setClient(new Client(roomDTO.getClientName()));
        if (roomDTO.getClientName() == null || roomDTO.getClientName().equals("null") || roomDTO.getClientName().equals("")) {
            room.setStatus(Status.FREE);
        } else {
            room.setStatus(Status.BUSY);
        }
        return room;
    }

    public static Service convertToService(ServiceDTO serviceDTO) throws Exception {
        return new Service(serviceDTO.getServiceName(), serviceDTO.getPrice());
    }

    public static String convertToWritableString(Room room) {
        RoomDTO roomDTO = new RoomDTO(room.getNumber(), room.getPrice());
        roomDTO.setClientName(room.getClient().getName());
        return roomDTO.toString();
    }

    public static String convertToWritableString(Service service) {
        ServiceDTO serviceDTO = new ServiceDTO(service.getServiceName(), service.getPrice());
        return serviceDTO.toString();
    }
}
