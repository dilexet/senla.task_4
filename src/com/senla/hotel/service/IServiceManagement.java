package com.senla.hotel.service;

import com.senla.hotel.entity.Service;
import com.senla.hotel.enums.ServiceSortingType;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public interface IServiceManagement {
    List<Service> getServices(ServiceSortingType serviceSortingType) throws Exception;

    String changePriceService(String id, double newPrice) throws Exception;

    String addService(Service service) throws Exception;

    Service getById(String id) throws Exception;
}
