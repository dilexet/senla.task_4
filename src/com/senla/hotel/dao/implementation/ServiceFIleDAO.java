package com.senla.hotel.dao.implementation;

import com.senla.hotel.dao.IServiceDAO;
import com.senla.hotel.entity.Service;
import com.senla.hotel.filetools.IParserCSV;
import com.senla.hotel.filetools.implementation.FileStreamReader;
import com.senla.hotel.filetools.implementation.FileStreamWriter;
import com.senla.hotel.tools.Converter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    public void save(Service service) {
        service.setId(UUID.randomUUID().toString());
        fileStreamWriter.fileWrite(Converter.convertToWritableString(service), true);
    }

    @Override
    public void update(Service service) throws Exception {
        List<Service> services = getServices();
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
        fileStreamWriter.fileWrite(data.toString(), false);
    }

    @Override
    public List<Service> getServices() throws Exception {
        String fileData = fileStreamReader.fileRead();
        return parserCSV.parseFileServices(fileData);
    }
}
