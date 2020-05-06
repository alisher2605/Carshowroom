package kz.iitu.carshowroom.Service;

import kz.iitu.carshowroom.Entity.Client;
import kz.iitu.carshowroom.Entity.UserType;

import java.util.List;

public interface  ClientService {
    List<Client> getAllClients();

    void creatClient(Client client);
    void updateClient(long id, Client client);
    void deleteClient(long id);
    Client findClientById(long id);
    void updateClientType(UserType userType, long id);
}
