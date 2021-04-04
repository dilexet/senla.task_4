package com.senla.filetools;

import com.senla.dataaccessobject.RoomDTO;
import com.senla.dataaccessobject.ServiceDTO;

import java.util.ArrayList;

public interface IParserCSV {
    ArrayList<RoomDTO> parseFileRooms(String fileData, char cvsSplitBy) throws Exception;
    ArrayList<ServiceDTO> parseFileServices(String fileData, char cvsSplitBy) throws Exception;
}
