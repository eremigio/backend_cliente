package reto.reto.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reto.reto.domain.Client;
import reto.reto.domain.DataExternal;
import reto.reto.domain.service.ClientService;
import reto.reto.persistence.entity.Cliente;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClientService clientService;
    @ApiOperation("Lista los clientes")
    @PostMapping("/listclientes")
    public List<Client> getAll(){
       return clientService.getAll();
    }
    @PostMapping("/creacliente")
    public Client save(Client client){
        return clientService.save(client);
    }
    @PostMapping("/kpicliente")
    public DataExternal dataExternal(){
        return clientService.dataexternal();
    }
    @GetMapping("/prueba")
    public String hola(){
        return "Hola mundo";
    }
}
