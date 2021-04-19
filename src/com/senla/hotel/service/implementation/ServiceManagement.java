package com.senla.hotel.service.implementation;

import com.senla.hotel.dao.IServiceDAO;
import com.senla.hotel.dto.ServiceDTO;
import com.senla.hotel.entity.Service;
import com.senla.hotel.service.IServiceManagement;

import java.util.Comparator;
import java.util.TreeSet;

public class ServiceManagement implements IServiceManagement {
    private final IServiceDAO serviceDAO;

    public ServiceManagement(IServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    public String sort(Comparator<Service> serviceComparator) throws Exception {
        TreeSet<Service> roomsSorted = new TreeSet<>(serviceComparator);
        roomsSorted.addAll(serviceDAO.getServices());
        return roomsSorted.toString();
    }

    public String changePriceService(ServiceDTO serviceDTO) throws Exception {
        var service = serviceDAO.getServices().stream().filter(r -> r.getServiceName().equals(serviceDTO.getServiceName())).findFirst();
        if (service.isEmpty()) {
            return "Service not found";
        } else {
            service.get().setPrice(serviceDTO.getPrice());
            serviceDAO.update(service.get());
            return "The cost of the " + service.get().getServiceName() + " service has been changed to " + service.get().getPrice() + "$";
        }
    }

    public String addService(ServiceDTO serviceDTO) throws Exception {
        var service = serviceDAO.getServices().stream().filter(r -> r.getServiceName().equals(serviceDTO.getServiceName())).findFirst();
        if (service.isPresent()) {
            return "A service with this name already exists";
        } else {
            serviceDAO.save(new Service(serviceDTO.getServiceName(), serviceDTO.getPrice()));
            return "Service " + serviceDTO.getServiceName() + " added successfully";
        }
    }
}
