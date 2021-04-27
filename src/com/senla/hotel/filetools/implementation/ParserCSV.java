package com.senla.hotel.filetools.implementation;

import com.senla.hotel.entity.Client;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;
import com.senla.hotel.filetools.IParserCSV;

import java.util.ArrayList;
import java.util.List;


public class ParserCSV implements IParserCSV {
    private final char csvSplitBy;

    public ParserCSV(char csvSplitBy) {
        this.csvSplitBy = csvSplitBy;
    }

    @Override
    public List<Room> parseFileRooms(String fileData) throws Exception {
        String[] lines = fileData.split("\n");
        List<Room> rooms = new ArrayList<>();
        for (String line : lines) {
            if (!line.equals("")) {
                String[] values = line.split(String.valueOf(csvSplitBy));
                rooms.add(convertToRoom(values));
            }
        }
        return rooms;
    }

    @Override
    public List<Service> parseFileServices(String fileData) throws Exception {
        String[] lines = fileData.split("\n");
        List<Service> services = new ArrayList<>();
        for (String line : lines) {
            if (!line.equals("")) {
                String[] values = line.split(String.valueOf(csvSplitBy));
                services.add(convertToService(values));
            }
        }
        return services;
    }

    @Override
    public List<Client> parseFileClients(String fileData) throws Exception {
        String[] lines = fileData.split("\n");
        List<Client> clients = new ArrayList<>();
        for (String line : lines) {
            if (!line.equals("")) {
                String[] values = line.split(String.valueOf(csvSplitBy));
                clients.add(convertToClient(values));
            }
        }
        return clients;
    }

    private Room convertToRoom(String[] values) throws Exception {
        if (values == null || values[0] == null || values[1] == null || values[2] == null || values[3] == null) {
            throw new NullPointerException("values is empty");
        }
        Room room = new Room(Integer.parseInt(values[1]), Double.parseDouble(values[2]));
        room.setId(values[0]);
        room.setClientId((values[3]));
        return room;
    }

    private Service convertToService(String[] values) throws Exception {
        if (values == null || values[0] == null || values[1] == null || values[2] == null) {
            throw new NullPointerException("values is empty");
        }
        Service service = new Service(values[1], Double.parseDouble(values[2]));
        service.setId(values[0]);
        return service;
    }

    private Client convertToClient(String[] values) throws Exception {
        if (values == null || values[0] == null || values[1] == null) {
            throw new NullPointerException("values is empty");
        }
        Client client = new Client(values[1]);
        client.setId(values[0]);
        return client;
    }
}
