package com.senla.builder;

import com.senla.comparators.room.RoomClientComparator;
import com.senla.comparators.room.RoomNumberComparator;
import com.senla.comparators.service.ServiceNameComparator;
import com.senla.comparators.service.ServicePriceComparator;
import com.senla.dao.implementation.RoomFileDAO;
import com.senla.dao.implementation.ServiceFIleDAO;
import com.senla.entity.Client;
import com.senla.enums.Status;
import com.senla.filetools.implementation.FileStreamReader;
import com.senla.filetools.implementation.FileStreamWriter;
import com.senla.filetools.implementation.ParserCSV;
import com.senla.manager.Administrator;
import com.senla.service.implementation.RoomManagement;
import com.senla.service.implementation.ServiceManagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Initializer {

    public void run() {
        try {
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

            Administrator administrator = new Administrator(
                    roomManagement,
                    serviceManagement);

            System.out.println(administrator.addRoom(666, 333));
            System.out.println(administrator.addService("Мини-бар", 228));
            System.out.println(administrator.changePriceRoom(666, 345));
            System.out.println(administrator.changePriceService("Мини-бар", 822));
            System.out.println(administrator.changeRoomStatus(666, Status.REPAIRED));
            System.out.println(administrator.changeRoomStatus(666, Status.FREE));
            System.out.println(administrator.checkInRoom(new Client()));
            System.out.println(administrator.checkOutRoom(666));

            System.out.println(administrator.sortRoom(new RoomClientComparator().thenComparing(new RoomNumberComparator())));
            System.out.println(administrator.sortService(new ServiceNameComparator().thenComparing(new ServicePriceComparator())));
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
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
