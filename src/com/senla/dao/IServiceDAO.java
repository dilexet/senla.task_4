package com.senla.dao;

import com.senla.entity.Service;

import java.io.IOException;
import java.util.List;

public interface IServiceDAO {
    void save(Service service);
    void update(Service service) throws Exception;
    List<Service> getServices() throws Exception;
}
