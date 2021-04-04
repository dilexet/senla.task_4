package com.senla.filetools.implementation;

import com.senla.dataaccessobject.RoomDTO;
import com.senla.dataaccessobject.ServiceDTO;
import com.senla.enums.Status;
import com.senla.filetools.IParserCSV;

import java.util.ArrayList;

public class ParserCSV implements IParserCSV {
    @Override
    public ArrayList<RoomDTO> parseFileRooms(String fileData, char cvsSplitBy) throws Exception {
        String[] lines = fileData.split("\n");
        ArrayList<RoomDTO> roomsDTO = new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {
            String[] values = lines[i].split(String.valueOf(cvsSplitBy));
            roomsDTO.add(convertToRoomDTO(values));
        }
        return roomsDTO;
    }

    @Override
    public ArrayList<ServiceDTO> parseFileServices(String fileData, char cvsSplitBy) throws Exception {
        String[] lines = fileData.split("\n");
        ArrayList<ServiceDTO> servicesDTO = new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {
            String[] values = lines[i].split(String.valueOf(cvsSplitBy));
            servicesDTO.add(convertToServiceDTO(values));
        }
        return servicesDTO;
    }

    private RoomDTO convertToRoomDTO(String[] values) throws Exception {
        if (values == null) {
            throw new NullPointerException("values is empty");
        }
        RoomDTO roomDTO = new RoomDTO();
        try {
            if (values[0] == null) {
                throw new Exception("id is null");
            }
            roomDTO.setId(Integer.parseInt(values[0]));
            if (values[1] == null) {
                throw new Exception("number is null");
            }
            roomDTO.setNumber(Integer.parseInt(values[1]));
            if (values[2] == null) {
                throw new Exception("price is null");
            }
            roomDTO.setPrice(Double.parseDouble(values[2]));
            if (values.length < 4) {
                roomDTO.setClientName(null);
                roomDTO.setStatus(Status.FREE);
            } else {
                roomDTO.setClientName(values[3]);
                roomDTO.setStatus(Status.BUSY);
            }
        } catch (Exception ex) {
            throw new Exception(ex.toString());
        }

        return roomDTO;
    }

    private ServiceDTO convertToServiceDTO(String[] values) throws Exception {
        if (values == null) {
            throw new NullPointerException("values is empty");
        }
        ServiceDTO serviceDTO = new ServiceDTO();
        try {
            if (values[0] == null) {
                throw new Exception("id is null");
            }
            serviceDTO.setId(Integer.parseInt(values[0]));

            if (values[1] == null) {
                throw new Exception("service name is null");
            }
            serviceDTO.setServiceName(values[1]);

            if (values[2] == null) {
                throw new Exception("price is null");
            }
            serviceDTO.setPrice(Double.parseDouble(values[2]));

        } catch (Exception ex) {
            throw new Exception(ex.toString());
        }
        return serviceDTO;
    }
}
