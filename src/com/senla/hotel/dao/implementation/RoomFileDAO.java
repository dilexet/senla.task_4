package com.senla.hotel.dao.implementation;

import com.senla.hotel.dao.IRoomDAO;
import com.senla.hotel.entity.Room;
import com.senla.hotel.filetools.IParserCSV;
import com.senla.hotel.filetools.implementation.FileStreamReader;
import com.senla.hotel.filetools.implementation.FileStreamWriter;
import com.senla.hotel.tools.ConvertDTO;

import java.util.ArrayList;
import java.util.List;

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
        fileStreamWriter.fileWrite(ConvertDTO.convertToWritableString(room), true);
    }

    @Override
    public void update(Room room) throws Exception {
        List<Room> rooms = getRooms();
        var value = rooms.stream().filter(s -> s.getNumber() == room.getNumber()).findFirst().orElse(null);
        if (value == null) {
            throw new Exception("Room with this number was not found");
        }
        var index = rooms.indexOf(value);
        rooms.set(index, room);
        StringBuilder data = new StringBuilder();
        for (var item : rooms) {
            data.append(ConvertDTO.convertToWritableString(item));
        }
        fileStreamWriter.fileWrite(data.toString(), false);
    }

    @Override
    public List<Room> getRooms() throws Exception {
        String fileData = fileStreamReader.fileRead();
        var roomsDTO = parserCSV.parseFileRooms(fileData);
        List<Room> rooms = new ArrayList<>();
        for (var room : roomsDTO) {
            rooms.add(ConvertDTO.convertToRoom(room));
        }
        return rooms;
    }
}
