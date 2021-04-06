package com.senla.service;

import com.senla.entity.Hotel;
import com.senla.entity.Service;

import java.util.Comparator;

public interface IServiceManagement {
    String sort(Hotel hotel, Comparator<Service> serviceComparator);

    String changePriceService(Hotel hotel, String serviceName, double price) throws Exception;

    String addService(Hotel hotel, String serviceName, double price) throws Exception;
}
