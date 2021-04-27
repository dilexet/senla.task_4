package com.senla.hotel.service.implementation;

import com.senla.hotel.dao.IServiceDAO;
import com.senla.hotel.entity.Service;
import com.senla.hotel.service.IServiceManagement;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.UUID;

public class ServiceManagement implements IServiceManagement {
    private final IServiceDAO serviceDAO;

    public ServiceManagement(IServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    public TreeSet<Service> sort(Comparator<Service> serviceComparator) throws Exception {
        TreeSet<Service> roomsSorted = new TreeSet<>(serviceComparator);
        roomsSorted.addAll(serviceDAO.getServices());
        return roomsSorted;
    }

    public String changePriceService(String id, double newPrice) throws Exception {
        var services = serviceDAO.getServices().stream().filter(r -> r.getId().equals(id)).findFirst();
        if (services.isEmpty()) {
            return "Service not found";
        } else {
            services.get().setPrice(newPrice);
            serviceDAO.update(services.get());
            return "The cost of the " + services.get().getServiceName() + " service has been changed to " + services.get().getPrice() + "$";
        }
    }

    public String addService(Service service) throws Exception {
        var services = serviceDAO.getServices().stream().filter(r -> r.getServiceName().equals(service.getServiceName())).findFirst();
        if (services.isPresent()) {
            return "A service with this name already exists";
        } else {
            serviceDAO.save(service);
            return "Service " + service.getServiceName() + " added successfully";
        }
    }
}
