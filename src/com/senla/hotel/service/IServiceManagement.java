package com.senla.hotel.service;

import com.senla.hotel.entity.Service;
import com.senla.hotel.enums.ServiceSortingType;

import java.util.List;

public interface IServiceManagement {
    List<Service> getServices(ServiceSortingType serviceSortingType) throws Exception;

    String changePriceService(String id, double newPrice) throws Exception;

    String addService(Service service) throws Exception;

    Service getById(String id) throws Exception;
}
