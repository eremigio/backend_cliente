package reto.reto.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto.reto.domain.Client;
import reto.reto.domain.DataExternal;
import reto.reto.domain.repository.ClientRepository;
import reto.reto.persistence.entity.Cliente;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Client save(Client client){
        return clientRepository.save(client);
    }
    public DataExternal dataexternal(){
        return clientRepository.dataexternal();
    }
}
