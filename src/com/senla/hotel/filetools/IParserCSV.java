package com.senla.hotel.filetools;

import com.senla.hotel.entity.Client;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;

import java.util.List;

public interface IParserCSV {
    List<Room> parseFileRooms(String[] lines) throws Exception;
    List<Service> parseFileServices(String[] lines) throws Exception;
    List<Client> parseFileClients(String[] lines) throws Exception;
}
