package com.senla.hotel.tools;

import com.senla.hotel.dto.RoomDTO;
import com.senla.hotel.dto.ServiceDTO;
import com.senla.hotel.entity.Client;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;

public class Converter {

    public static RoomDTO convertToDTO(Room room, Client client) throws Exception {
        return new RoomDTO(room.getNumber(), room.getPrice(), room.getStatus(), client);
    }

    public static ServiceDTO convertToDTO(Service service) throws Exception {
        return new ServiceDTO(service.getServiceName(), service.getPrice());
    }

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
