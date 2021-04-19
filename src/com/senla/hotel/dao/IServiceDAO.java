package com.senla.hotel.dao;

import com.senla.hotel.entity.Service;

import java.util.List;

public interface IServiceDAO {
    void save(Service service);
    void update(Service service) throws Exception;
    List<Service> getServices() throws Exception;
}
