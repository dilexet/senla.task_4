package com.senla.filetools.implementation;

import com.senla.dataaccessobject.RoomDTO;
import com.senla.dataaccessobject.ServiceDTO;
import com.senla.enums.Status;
import com.senla.filetools.IParserCSV;

import java.util.ArrayList;

public class ParserCSV implements IParserCSV {
    @Override
    public ArrayList<RoomDTO> parseFileRooms(String fileData, char cvsSplitBy) {
        String[] lines = fileData.split("\n");
        ArrayList<RoomDTO> roomsDTO = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            if (!lines[i].equals("")) {
                String[] values = lines[i].split(String.valueOf(cvsSplitBy));
                roomsDTO.add(convertToRoomDTO(values));
            }
        }
        return roomsDTO;
    }

    @Override
    public ArrayList<ServiceDTO> parseFileServices(String fileData, char cvsSplitBy) {
        String[] lines = fileData.split("\n");
        ArrayList<ServiceDTO> servicesDTO = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            if (!lines[i].equals("")) {
                String[] values = lines[i].split(String.valueOf(cvsSplitBy));
                servicesDTO.add(convertToServiceDTO(values));
            }
        }
        return servicesDTO;
    }

    private RoomDTO convertToRoomDTO(String[] values) {
        if (values == null || values[0] == null || values[1] == null || values[2] == null) {
            throw new NullPointerException("values is empty");
        }
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(Integer.parseInt(values[0]));
        roomDTO.setNumber(Integer.parseInt(values[1]));
        roomDTO.setPrice(Double.parseDouble(values[2]));
        if (values[3] == null || values[3].equals("null")) {
            roomDTO.setClientName(null);
            roomDTO.setStatus(Status.FREE);
        } else {
            roomDTO.setClientName(values[3]);
            roomDTO.setStatus(Status.BUSY);
        }
        return roomDTO;
    }

    private ServiceDTO convertToServiceDTO(String[] values) {
        if (values == null || values[0] == null || values[1] == null || values[2] == null) {
            throw new NullPointerException("values is empty");
        }
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setId(Integer.parseInt(values[0]));
        serviceDTO.setServiceName(values[1]);
        serviceDTO.setPrice(Double.parseDouble(values[2]));
        return serviceDTO;
    }
}
