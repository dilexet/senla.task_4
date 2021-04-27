package com.senla.hotel.tools;

import com.senla.hotel.entity.Client;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;

public class Converter {
    /*
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
    */

    public static String convertToWritableString(Room room) {

        return room.getId() + "," + room.getNumber() + "," + room.getPrice() + "," + room.getClientId() + "\n";
    }

    public static String convertToWritableString(Service service) {
        return service.getId() + "," + service.getServiceName() + "," + service.getPrice() + "\n";
    }

    public static String convertToWritableString(Client client) {
        return client.getId() + "," + client.getName() + "\n";
    }
}
