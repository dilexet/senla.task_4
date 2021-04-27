package com.senla.hotel.service;

import com.senla.hotel.entity.Client;

import java.util.List;

public interface IClientManagement {
    void addClient(Client client) throws Exception;

    Client getClientById(String id) throws Exception;

    List<Client> getClients() throws Exception;
}
