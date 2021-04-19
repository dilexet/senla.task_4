package com.senla.hotel.filetools.implementation;

import com.senla.hotel.dto.RoomDTO;
import com.senla.hotel.dto.ServiceDTO;
import com.senla.hotel.filetools.IParserCSV;

import java.util.ArrayList;
import java.util.List;


public class ParserCSV implements IParserCSV {
    private final char csvSplitBy;

    public ParserCSV(char csvSplitBy){
        this.csvSplitBy = csvSplitBy;
    }

    @Override
    public List<RoomDTO> parseFileRooms(String fileData) {
        String[] lines = fileData.split("\n");
        List<RoomDTO> roomsDTO = new ArrayList<>();
        for (String line : lines) {
            if (!line.equals("")) {
                String[] values = line.split(String.valueOf(csvSplitBy));
                roomsDTO.add(convertToRoomDTO(values));
            }
        }
        return roomsDTO;
    }

    @Override
    public List<ServiceDTO> parseFileServices(String fileData) {
        String[] lines = fileData.split("\n");
        List<ServiceDTO> servicesDTO = new ArrayList<>();
        for (String line : lines) {
            if (!line.equals("")) {
                String[] values = line.split(String.valueOf(csvSplitBy));
                servicesDTO.add(convertToServiceDTO(values));
            }
        }
        return servicesDTO;
    }

    private RoomDTO convertToRoomDTO(String[] values) {
        if (values == null || values[0] == null || values[1] == null || values[2] == null) {
            throw new NullPointerException("values is empty");
        }
        RoomDTO roomDTO = new RoomDTO(Integer.parseInt(values[0]), Double.parseDouble(values[1]));
        roomDTO.setClientName(values[2]);
        return roomDTO;
    }

    private ServiceDTO convertToServiceDTO(String[] values) {
        if (values == null || values[0] == null || values[1] == null) {
            throw new NullPointerException("values is empty");
        }
        return new ServiceDTO(values[0], Double.parseDouble(values[1]));
    }
}
