package ubb.movierentals.ClientEntity.service;

import ubb.movierentals.ClientEntity.model.Client;

import java.util.List;

public interface IClientService {
    List<Client> getAllClients();

    Client addClient(Client client);

    Client getClientById(Long id);

    Client updateClient(Long id, Client client);

    void deleteClientById(Long id);

}
