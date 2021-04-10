package com.senla.dao.implementation;

import com.senla.dao.IRoomDAO;
import com.senla.entity.Room;
import com.senla.filetools.IParserCSV;
import com.senla.filetools.implementation.FileStreamReader;
import com.senla.filetools.implementation.FileStreamWriter;
import com.senla.tools.ConvertDTO;

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
        fileStreamWriter.fileWrite(ConvertDTO.convertToRoomDTO(room).toString(), true);
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
            data.append(ConvertDTO.convertToRoomDTO(item).toString());
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
