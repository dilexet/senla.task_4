package com.senla.hotel.dao.implementation;

import com.senla.hotel.dao.IServiceDAO;
import com.senla.hotel.entity.Service;
import com.senla.hotel.enums.ServiceSortingType;
import com.senla.hotel.filetools.IParserCSV;
import com.senla.hotel.filetools.implementation.FileStreamReader;
import com.senla.hotel.filetools.implementation.FileStreamWriter;
import com.senla.hotel.tools.Converter;
import com.senla.hotel.tools.Properties;

import java.util.*;

public class ServiceFIleDAO implements IServiceDAO {
    private final IParserCSV parserCSV;
    private final FileStreamWriter fileStreamWriter;
    private final FileStreamReader fileStreamReader;

    public ServiceFIleDAO(IParserCSV parserCSV, FileStreamWriter fileStreamWriter, FileStreamReader fileStreamReader) {
        this.parserCSV = parserCSV;
        this.fileStreamWriter = fileStreamWriter;
        this.fileStreamReader = fileStreamReader;
    }

    @Override
    public void saveOrUpdate(Service service) throws Exception {
        if (service.getId() != null) {
            List<Service> services = getServices(ServiceSortingType.NONE);
            var value = services.stream().filter(s -> s.getServiceName().equals(service.getServiceName())).findFirst().orElse(null);
            if (value == null) {
                throw new Exception("Service with this name was not found");
            }

            var index = services.indexOf(value);
            services.set(index, service);
            StringBuilder data = new StringBuilder();
            for (var item : services) {
                data.append(Converter.convertToWritableString(item));
            }
            fileStreamWriter.fileWrite(Properties.getInstance().getProperty("servicesFilePath"), data.toString(), false);
        } else {
            service.setId(UUID.randomUUID().toString());
            fileStreamWriter.fileWrite(Properties.getInstance().getProperty("servicesFilePath"), Converter.convertToWritableString(service), true);
        }
    }

    @Override
    public Service getById(String id) throws Exception {
        var service = getServices(ServiceSortingType.NONE).stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
        if (service == null) {
            throw new Exception("Room not found");
        }
        return service;
    }

    @Override
    public List<Service> getServices(ServiceSortingType serviceSortingType) throws Exception {
        var fileData = fileStreamReader.fileRead(Properties.getInstance().getProperty("servicesFilePath"));
        TreeSet<Service> servicesSorted = switch (serviceSortingType) {
            case NONE -> new TreeSet<>(Comparator.comparing(Service::getId));
            case NAME -> new TreeSet<>(Comparator.comparing(Service::getServiceName));
            case PRICE -> new TreeSet<>(Comparator.comparing(Service::getPrice));
        };
        var services = parserCSV.parseFileServices(fileData);
        servicesSorted.addAll(services);
        return new ArrayList<>(servicesSorted);
    }
}
