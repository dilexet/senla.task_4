package com.senla.hotel.dao.implementation;

import com.senla.hotel.dao.IClientFileDAO;
import com.senla.hotel.entity.Client;
import com.senla.hotel.filetools.IParserCSV;
import com.senla.hotel.filetools.implementation.FileStreamReader;
import com.senla.hotel.filetools.implementation.FileStreamWriter;
import com.senla.hotel.tools.Converter;

import java.util.List;
import java.util.UUID;

public class ClientFileDAO implements IClientFileDAO {
    private final IParserCSV parserCSV;
    private final FileStreamWriter fileStreamWriter;
    private final FileStreamReader fileStreamReader;

    public ClientFileDAO(IParserCSV parserCSV, FileStreamWriter fileStreamWriter, FileStreamReader fileStreamReader) {
        this.parserCSV = parserCSV;
        this.fileStreamWriter = fileStreamWriter;
        this.fileStreamReader = fileStreamReader;
    }

    @Override
    public void saveOrUpdate(Client client) throws Exception {
        if (client.getId() != null) {
            List<Client> clients = getClients();
            var value = clients.stream().filter(s -> s.getId().equals(client.getId())).findFirst().orElse(null);
            if (value == null) {
                throw new Exception("Client with this name was not found");
            }
            var index = clients.indexOf(value);
            clients.set(index, client);
            StringBuilder data = new StringBuilder();
            for (var item : clients) {
                data.append(Converter.convertToWritableString(item));
            }
            fileStreamWriter.fileWrite(data.toString(), false);
        } else {
            client.setId(UUID.randomUUID().toString());
            fileStreamWriter.fileWrite(Converter.convertToWritableString(client), true);
        }
    }

    @Override
    public Client getById(String id) throws Exception {
        if (id == null || id.equals("null") || id.equals("")) {
            return new Client("");
        }
        var client = getClients().stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
        if (client == null) {
            throw new Exception("Client not found");
        }
        return client;
    }

    @Override
    public List<Client> getClients() throws Exception {
        var fileData = fileStreamReader.fileRead();
        return parserCSV.parseFileClients(fileData);
    }
}
