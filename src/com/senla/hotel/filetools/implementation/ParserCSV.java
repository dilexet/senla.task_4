package com.senla.hotel.filetools.implementation;

import com.senla.hotel.entity.Client;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;
import com.senla.hotel.enums.Status;
import com.senla.hotel.filetools.IParserCSV;

import java.util.ArrayList;
import java.util.List;


public class ParserCSV implements IParserCSV {
    private final char csvSplitBy;

    public ParserCSV(char csvSplitBy) {
        this.csvSplitBy = csvSplitBy;
    }

    @Override
    public List<Room> parseFileRooms(String[] lines) throws Exception {
        List<Room> rooms = new ArrayList<>();
        for (String line : lines) {
            if (!line.equals("")) {
                String[] values = line.split(String.valueOf(csvSplitBy));
                rooms.add(convertToRoom(values));
            }
        }
        return rooms;
    }

    private Room convertToRoom(String[] values) throws Exception {
        if (values == null || values[0] == null || values[1] == null || values[2] == null || values[3] == null || values[4] == null) {
            throw new NullPointerException("values is empty");
        }
        Room room = new Room(Integer.parseInt(values[1]), Double.parseDouble(values[2]));
        room.setId(values[0]);
        room.setStatus(Status.valueOf(values[3]));
        room.setClientId((values[4]));
        return room;
    }

    @Override
    public List<Service> parseFileServices(String[] lines) throws Exception {
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
    public List<Client> parseFileClients(String[] lines) {
        List<Client> clients = new ArrayList<>();
        for (String line : lines) {
            if (!line.equals("")) {
                String[] values = line.split(String.valueOf(csvSplitBy));
                clients.add(convertToClient(values));
            }
        }
        return clients;
    }

    private Service convertToService(String[] values) throws Exception {
        if (values == null || values[0] == null || values[1] == null || values[2] == null) {
            throw new NullPointerException("values is empty");
        }
        Service service = new Service(values[1], Double.parseDouble(values[2]));
        service.setId(values[0]);
        return service;
    }

    private Client convertToClient(String[] values) {
        if (values == null || values[0] == null || values[1] == null) {
            throw new NullPointerException("values is empty");
        }
        Client client = new Client(values[1]);
        client.setId(values[0]);
        return client;
    }
}
