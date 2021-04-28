package com.senla.hotel.builder;

import com.senla.hotel.dao.implementation.ClientFileDAO;
import com.senla.hotel.dao.implementation.RoomFileDAO;
import com.senla.hotel.dao.implementation.ServiceFIleDAO;
import com.senla.hotel.filetools.implementation.FileStreamReader;
import com.senla.hotel.filetools.implementation.FileStreamWriter;
import com.senla.hotel.filetools.implementation.ParserCSV;
import com.senla.hotel.manager.Administrator;
import com.senla.hotel.service.implementation.ClientManagement;
import com.senla.hotel.service.implementation.RoomManagement;
import com.senla.hotel.service.implementation.ServiceManagement;
import com.senla.hotel.tools.Log;
import com.senla.hotel.tools.LoggerConfiguration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Initializer {
    public Administrator initialize() throws IOException {

        String logFilePath = getProperty("logFilePath");
        FileStreamWriter logWriter = new FileStreamWriter(logFilePath);
        Log.Logger = new LoggerConfiguration(logWriter);

        String roomsFilePath = getProperty("roomsFilePath");
        String servicesFilePath = getProperty("servicesFilePath");
        String clientFilePath = getProperty("clientFilePath");
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

        ClientFileDAO clientFileDAO = new ClientFileDAO(
                parserCSV,
                new FileStreamWriter(clientFilePath),
                new FileStreamReader(clientFilePath));

        RoomManagement roomManagement = new RoomManagement(roomFileDAO);
        ServiceManagement serviceManagement = new ServiceManagement(serviceFIleDAO);
        ClientManagement clientManagement = new ClientManagement(clientFileDAO);
        return new Administrator(roomManagement, serviceManagement, clientManagement);
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
