package com.senla.comparators.service;

import com.senla.entity.Service;

import java.util.Comparator;

public class ServiceNameComparator implements Comparator<Service> {
    @Override
    public int compare(Service service1, Service service2) {
        return service1.getServiceName().compareTo(service2.getServiceName());
    }
}
