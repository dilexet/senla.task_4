package com.senla.hotel.service;

import com.senla.hotel.dto.ServiceDTO;
import com.senla.hotel.entity.Service;

import java.util.Comparator;

public interface IServiceManagement {
    String sort(Comparator<Service> serviceComparator) throws Exception;

    String changePriceService(ServiceDTO serviceDTO) throws Exception;

    String addService(ServiceDTO serviceDTO) throws Exception;
}
