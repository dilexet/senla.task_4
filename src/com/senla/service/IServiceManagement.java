package com.senla.service;

import com.senla.entity.Service;

import java.util.Comparator;

public interface IServiceManagement {
    String sort(Comparator<Service> serviceComparator) throws Exception;

    String changePriceService(String serviceName, double price) throws Exception;

    String addService(String serviceName, double price) throws Exception;
}
