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
import com.senla.hotel.tools.Properties;

import java.io.IOException;


public class Initializer {
    public Administrator initialize() throws IOException {
        FileStreamWriter fileStreamWriter = new FileStreamWriter();
        FileStreamReader fileStreamReader = new FileStreamReader();

        char cvsSplitBy = Properties.getInstance().getProperty("cvsSplitBy").charAt(1);

        ParserCSV parserCSV = new ParserCSV(cvsSplitBy);

        RoomFileDAO roomFileDAO = new RoomFileDAO(
                parserCSV,
                fileStreamWriter,
                fileStreamReader);

        ServiceFIleDAO serviceFIleDAO = new ServiceFIleDAO(
                parserCSV,
                fileStreamWriter,
                fileStreamReader);

        ClientFileDAO clientFileDAO = new ClientFileDAO(
                parserCSV,
                fileStreamWriter,
                fileStreamReader);

        RoomManagement roomManagement = new RoomManagement(roomFileDAO);
        ServiceManagement serviceManagement = new ServiceManagement(serviceFIleDAO);
        ClientManagement clientManagement = new ClientManagement(clientFileDAO);
        return new Administrator(roomManagement, serviceManagement, clientManagement);
    }


}
