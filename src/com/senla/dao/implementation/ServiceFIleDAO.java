package com.senla.dao.implementation;

import com.senla.dao.IServiceDAO;
import com.senla.entity.Service;
import com.senla.filetools.IParserCSV;
import com.senla.filetools.implementation.FileStreamReader;
import com.senla.filetools.implementation.FileStreamWriter;
import com.senla.tools.ConvertDTO;

import java.util.ArrayList;
import java.util.List;

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
        fileStreamWriter.fileWrite(ConvertDTO.convertToServiceDTO(service).toString(), true);
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
            data.append(ConvertDTO.convertToServiceDTO(item).toString());
        }
        fileStreamWriter.fileWrite(data.toString(), false);
    }

    @Override
    public List<Service> getServices() throws Exception {
        String fileData = fileStreamReader.fileRead();
        var servicesDTO = parserCSV.parseFileServices(fileData);
        List<Service> services = new ArrayList<>();
        for (var service : servicesDTO) {
            services.add(ConvertDTO.convertToService(service));
        }
        return services;
    }
}
