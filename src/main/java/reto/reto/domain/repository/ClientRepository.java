package reto.reto.domain.repository;

import reto.reto.domain.Client;
import reto.reto.domain.DataExternal;

import java.util.List;

public interface ClientRepository {
    List<Client> getAll();
    Client save(Client client);
    DataExternal dataexternal();
}
