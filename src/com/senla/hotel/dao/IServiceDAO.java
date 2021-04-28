package com.senla.hotel.dao;

import com.senla.hotel.entity.Service;
import com.senla.hotel.enums.ServiceSortingType;

import java.util.List;

public interface IServiceDAO {
    void save(Service service);
    void update(Service service) throws Exception;
    Service getById(String id) throws Exception;
    List<Service> getServices(ServiceSortingType serviceSortingType) throws Exception;
}
