package com.senla.hotel.service.implementation;

import com.senla.hotel.dao.IClientFileDAO;
import com.senla.hotel.entity.Client;
import com.senla.hotel.service.IClientManagement;

import java.util.List;

public class ClientManagement implements IClientManagement {
    private final IClientFileDAO clientFileDAO;

    public ClientManagement(IClientFileDAO clientFileDAO) {
        this.clientFileDAO = clientFileDAO;
    }

    @Override
    public void addClient(Client client) throws Exception {
        clientFileDAO.saveOrUpdate(client);
    }

    public Client getById(String id) throws Exception {
       return clientFileDAO.getById(id);
    }

    public List<Client> getClients() throws Exception {
        return clientFileDAO.getClients();
    }
}
