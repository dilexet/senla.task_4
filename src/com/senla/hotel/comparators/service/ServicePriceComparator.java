package com.senla.hotel.comparators.service;

import com.senla.hotel.entity.Service;

import java.util.Comparator;

public class ServicePriceComparator implements Comparator<Service> {
    @Override
    public int compare(Service service1, Service service2) {
        return Double.compare(service1.getPrice(), service2.getPrice());
    }
}
