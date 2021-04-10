package com.senla.service.implementation;

import com.senla.dao.IServiceDAO;
import com.senla.entity.Service;
import com.senla.service.IServiceManagement;

import java.util.Comparator;
import java.util.TreeSet;

public class ServiceManagement implements IServiceManagement {
    private final IServiceDAO serviceDAO;

    public ServiceManagement(IServiceDAO serviceDAO){
        this.serviceDAO = serviceDAO;
    }

    public String sort(Comparator<Service> serviceComparator) throws Exception {
        TreeSet<Service> roomsSorted = new TreeSet<>(serviceComparator);
        roomsSorted.addAll(serviceDAO.getServices());
        return roomsSorted.toString();
    }

    public String changePriceService(String serviceName, double price) throws Exception {
        var service = serviceDAO.getServices().stream().filter(r -> r.getServiceName().equals(serviceName)).findFirst();
        if (service.isEmpty()) {
            return "Service not found";
        } else {
            service.get().setPrice(price);
            serviceDAO.update(service.get());
            return "The cost of the " + service.get().getServiceName() + " service has been changed to " + service.get().getPrice() + "$";
        }
    }

    public String addService(String serviceName, double price) throws Exception {
        var service = serviceDAO.getServices().stream().filter(r -> r.getServiceName().equals(serviceName)).findFirst();
        if (service.isPresent()) {
            return "A service with this name already exists";
        } else {
            serviceDAO.save(new Service(serviceName, price));
            return "Service " + serviceName + " added successfully";
        }
    }
}
