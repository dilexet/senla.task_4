package com.senla.hotel.dao;

import com.senla.hotel.entity.Client;

import java.util.List;

public interface IClientFileDAO {
    void saveOrUpdate(Client client) throws Exception;
    Client getById(String id) throws Exception;
    List<Client> getClients() throws Exception;
}
