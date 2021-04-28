package com.senla.hotel.service.implementation;

import com.senla.hotel.dao.IServiceDAO;
import com.senla.hotel.dto.ServiceDTO;
import com.senla.hotel.entity.Service;
import com.senla.hotel.enums.RoomSortingType;
import com.senla.hotel.enums.ServiceSortingType;
import com.senla.hotel.service.IServiceManagement;
import com.senla.hotel.tools.Converter;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class ServiceManagement implements IServiceManagement {
    private final IServiceDAO serviceDAO;

    public ServiceManagement(IServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    public List<Service> getServices(ServiceSortingType serviceSortingType) throws Exception {
        return serviceDAO.getServices(serviceSortingType);
    }

    public String changePriceService(String id, double newPrice) throws Exception {
        var services = serviceDAO.getServices(ServiceSortingType.NON).stream().filter(r -> r.getId().equals(id)).findFirst();
        if (services.isEmpty()) {
            return "Service not found";
        } else {
            services.get().setPrice(newPrice);
            serviceDAO.update(services.get());
            return "The cost of the " + services.get().getServiceName() + " service has been changed to " + services.get().getPrice() + "$";
        }
    }

    public String addService(Service service) throws Exception {
        var services = serviceDAO.getServices(ServiceSortingType.NON).stream().filter(r -> r.getServiceName().equals(service.getServiceName())).findFirst();
        if (services.isPresent()) {
            return "A service with this name already exists";
        } else {
            serviceDAO.save(service);
            return "Service " + service.getServiceName() + " added successfully";
        }
    }

    public Service getById(String id) throws Exception {
        return serviceDAO.getById(id);
    }
}
