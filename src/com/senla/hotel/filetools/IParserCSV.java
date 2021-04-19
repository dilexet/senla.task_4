package com.senla.hotel.filetools;

import com.senla.hotel.dto.RoomDTO;
import com.senla.hotel.dto.ServiceDTO;

import java.util.List;

public interface IParserCSV {
    List<RoomDTO> parseFileRooms(String fileData) throws Exception;
    List<ServiceDTO> parseFileServices(String fileData) throws Exception;
}
