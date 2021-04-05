package com.senla.tools;

import com.senla.dataaccessobject.RoomDTO;
import com.senla.dataaccessobject.ServiceDTO;
import com.senla.entity.Client;
import com.senla.entity.Room;
import com.senla.entity.Service;

public class ConvertDTO {
    public Room convertToRoom(RoomDTO roomDTO) throws Exception {
        Room room = new Room(roomDTO.getNumber(), roomDTO.getPrice());
        room.setClient(new Client(roomDTO.getClientName()));
        room.setStatus(roomDTO.getStatus());
        return room;
    }

    public Service convertToService(ServiceDTO serviceDTO) throws Exception {
        return new Service(serviceDTO.getServiceName(), serviceDTO.getPrice());
    }

    public RoomDTO convertToRoomDTO(Room room){
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setNumber(room.getNumber());
        roomDTO.setPrice(room.getPrice());
        roomDTO.setClientName(room.getClient().getName());
        roomDTO.setStatus(room.getStatus());
        return roomDTO;
    }

    public ServiceDTO convertToServiceDTO(Service service){
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setServiceName(service.getServiceName());
        serviceDTO.setPrice(service.getPrice());
        return serviceDTO;
    }
}
