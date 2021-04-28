package com.senla.hotel.dao.implementation;

import com.senla.hotel.dao.IRoomDAO;
import com.senla.hotel.entity.Room;
import com.senla.hotel.enums.RoomSortingType;
import com.senla.hotel.filetools.IParserCSV;
import com.senla.hotel.filetools.implementation.FileStreamReader;
import com.senla.hotel.filetools.implementation.FileStreamWriter;
import com.senla.hotel.tools.Converter;

import java.util.*;

public class RoomFileDAO implements IRoomDAO {
    private final IParserCSV parserCSV;
    private final FileStreamWriter fileStreamWriter;
    private final FileStreamReader fileStreamReader;

    public RoomFileDAO(IParserCSV parserCSV, FileStreamWriter fileStreamWriter, FileStreamReader fileStreamReader) {
        this.parserCSV = parserCSV;
        this.fileStreamWriter = fileStreamWriter;
        this.fileStreamReader = fileStreamReader;
    }

    @Override
    public void save(Room room) {
        room.setId(UUID.randomUUID().toString());
        fileStreamWriter.fileWrite(Converter.convertToWritableString(room), true);
    }

    @Override
    public void update(Room room) throws Exception {
        List<Room> rooms = getRooms(RoomSortingType.NON);
        var value = rooms.stream().filter(s -> s.getNumber() == room.getNumber()).findFirst().orElse(null);
        if (value == null) {
            throw new Exception("Room with this number was not found");
        }
        var index = rooms.indexOf(value);
        rooms.set(index, room);
        StringBuilder data = new StringBuilder();
        for (var item : rooms) {
            data.append(Converter.convertToWritableString(item));
        }
        fileStreamWriter.fileWrite(data.toString(), false);
    }

    @Override
    public Room getById(String id) throws Exception {
        var room = getRooms(RoomSortingType.NON).stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
        if (room == null) {
            throw new Exception("Room not found");
        }
        return room;
    }

    @Override
    public List<Room> getRooms(RoomSortingType roomSortingType) throws Exception {
        var fileData = fileStreamReader.fileRead();
        TreeSet<Room> roomsSorted = switch (roomSortingType) {
            case NON -> new TreeSet<>(Comparator.comparing(Room::getId));
            case NUMBER -> new TreeSet<>(Comparator.comparing(Room::getNumber));
            case PRICE -> new TreeSet<>(Comparator.comparing(Room::getPrice));
            case STATUS -> new TreeSet<>(Comparator.comparing(Room::getStatus));
        };
        var rooms = parserCSV.parseFileRooms(fileData);
        roomsSorted.addAll(rooms);
        return new ArrayList<>(roomsSorted);
    }
}
