package com.senla.hotel.service;

import com.senla.hotel.entity.Service;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public interface IServiceManagement {
    TreeSet<Service> sort(Comparator<Service> serviceComparator) throws Exception;

    String changePriceService(String id, double newPrice) throws Exception;

    String addService(Service service) throws Exception;
}
