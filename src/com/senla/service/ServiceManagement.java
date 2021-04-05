package com.senla.service;

import com.senla.entity.Hotel;
import com.senla.entity.Service;
import com.senla.filetools.IFileStreamReader;
import com.senla.filetools.IFileStreamWriter;
import com.senla.filetools.IParserCSV;

public class ServiceManagement {
    private final IParserCSV parserCSV;
    private final IFileStreamWriter fileStreamWriter;
    private final IFileStreamReader fileStreamReader;

    public ServiceManagement(IParserCSV parserCSV, IFileStreamWriter fileStreamWriter, IFileStreamReader fileStreamReader) {
        this.parserCSV = parserCSV;
        this.fileStreamWriter = fileStreamWriter;
        this.fileStreamReader = fileStreamReader;
    }

    public String changePriceService(Hotel hotel, String serviceName, double price) throws Exception {
        var service = hotel.getServices().stream().filter(r -> r.getServiceName().equals(serviceName)).findFirst();
        if (service.isEmpty()) {
            return "Service not found";
        } else {
            service.get().setPrice(price);
            return "The cost of the " + service.get().getServiceName() + " service has been changed to " + service.get().getPrice() + "$";
        }
    }

    public String addService(Hotel hotel, String serviceName, double price) throws Exception {
        var service = hotel.getServices().stream().filter(r -> r.getServiceName().equals(serviceName)).findFirst();
        if (service.isPresent()) {
            return "A service with this name already exists";
        } else {
            hotel.getServices().add(new Service(serviceName, price));
            return "Service " + serviceName + " added successfully";
        }
    }
}
