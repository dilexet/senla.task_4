package com.senla.hotel.comparators.service;

import com.senla.hotel.entity.Service;

import java.util.Comparator;

public class ServiceNameComparator implements Comparator<Service> {
    @Override
    public int compare(Service service1, Service service2) {
        return service1.getServiceName().compareTo(service2.getServiceName());
    }
}
