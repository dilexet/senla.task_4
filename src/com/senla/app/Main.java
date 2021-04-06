package com.senla.app;

import com.senla.comparators.room.RoomClientComparator;
import com.senla.comparators.room.RoomNumberComparator;
import com.senla.comparators.service.ServiceNameComparator;
import com.senla.comparators.service.ServicePriceComparator;
import com.senla.entity.Client;
import com.senla.entity.Hotel;
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

public class Main {

    public static void main(String[] args) {
        try {
            // TODO: данные должны читаться при запуске или по мере необходимости?
            run(getProperty("roomsFilePath"), getProperty("servicesFilePath"), getProperty("cvsSplitBy").charAt(1));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static String getProperty(String propertyName) throws IOException {
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

    private static void run(String roomsFilePath, String servicesFilePath, char cvsSplitBy){
        try {
            Administrator administrator = new Administrator(
                    Hotel.getHotel(),
                    new RoomManagement(new ParserCSV(cvsSplitBy), new FileStreamWriter(roomsFilePath), new FileStreamReader(roomsFilePath)),
                    new ServiceManagement(new ParserCSV(cvsSplitBy), new FileStreamWriter(servicesFilePath), new FileStreamReader(servicesFilePath)));

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
}
