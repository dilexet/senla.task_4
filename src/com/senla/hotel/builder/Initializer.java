package com.senla.hotel.builder;

import com.senla.hotel.dao.implementation.RoomFileDAO;
import com.senla.hotel.dao.implementation.ServiceFIleDAO;
import com.senla.hotel.dto.RoomDTO;
import com.senla.hotel.dto.ServiceDTO;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;
import com.senla.hotel.filetools.implementation.FileStreamReader;
import com.senla.hotel.filetools.implementation.FileStreamWriter;
import com.senla.hotel.filetools.implementation.ParserCSV;
import com.senla.hotel.manager.Administrator;
import com.senla.hotel.service.implementation.RoomManagement;
import com.senla.hotel.service.implementation.ServiceManagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.Properties;

public class Initializer {
    public Administrator initialize() throws IOException {
            String roomsFilePath = getProperty("roomsFilePath");
            String servicesFilePath = getProperty("servicesFilePath");
            char cvsSplitBy = getProperty("cvsSplitBy").charAt(1);

            ParserCSV parserCSV = new ParserCSV(cvsSplitBy);

            RoomFileDAO roomFileDAO = new RoomFileDAO(
                    parserCSV,
                    new FileStreamWriter(roomsFilePath),
                    new FileStreamReader(roomsFilePath));

            ServiceFIleDAO serviceFIleDAO = new ServiceFIleDAO(
                    parserCSV,
                    new FileStreamWriter(servicesFilePath),
                    new FileStreamReader(servicesFilePath));

            RoomManagement roomManagement = new RoomManagement(roomFileDAO);
            ServiceManagement serviceManagement = new ServiceManagement(serviceFIleDAO);
        return new Administrator(roomManagement, serviceManagement);
    }

    private String getProperty(String propertyName) throws IOException {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("files.properties"));
        } catch (IOException e) {
            throw new IOException(e.toString());
        }
        String property = props.getProperty(propertyName);
        if (property == null) {
            throw new IOException("Property not found");
        }
        return property;
    }
}
