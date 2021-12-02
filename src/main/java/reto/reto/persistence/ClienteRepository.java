package reto.reto.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import reto.reto.domain.Client;
import reto.reto.domain.DataExternal;
import reto.reto.domain.repository.ClientRepository;
import reto.reto.persistence.crud.ClienteCrudRepository;
import reto.reto.persistence.entity.Cliente;
import reto.reto.persistence.mapper.ClientMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

@Repository
public class ClienteRepository implements ClientRepository {
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private ClienteCrudRepository clienteCrudRepository;
    @Value("${spring.lineamiento.esperanzavida}")
    private Integer esperanzavida;
    public List<Client> getAll(){
        List<Cliente> clienteList = (List<Cliente>) clienteCrudRepository.findAll();

        LocalDate dt = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        int index = 0;
        for(Cliente cliente: clienteList) {
            LocalDate date = LocalDate.parse(cliente.getFechanacimiento());
            Period periodo = Period.between(date, dt);
            Integer cant = esperanzavida - periodo.getYears();
            LocalDate anios = dt.plusYears(cant);
            Date dia = Date.from(anios.atStartOfDay(defaultZoneId).toInstant());
            clienteList.get(index).setFechafallecimiento(dia);
            index++;
        }

        return clientMapper.toClients(clienteList);
    }

    public Client save(Client client){
        Cliente cliente = clientMapper.toCliente(client);
        return clientMapper.toClient(clienteCrudRepository.save(cliente));
    }

    @Override
    public DataExternal dataexternal() {

        DataExternal dataExternal = new DataExternal();
        List<Cliente> clienteList = (List<Cliente>) clienteCrudRepository.findAll();
        long cantidad =  clienteList.stream().count();
        LocalDate dt = LocalDate.now();
        List<Integer> lst = new ArrayList<>();
        Integer ed = 0;
        double varianza = 0.0;
        double desviacion= 0.0;
        for (Cliente cliente: clienteList) {
            LocalDate date = LocalDate.parse(cliente.getFechanacimiento());
            Period periodo = Period.between(date, dt);
            ed +=periodo.getYears();

            double rango = Math.pow(periodo.getYears(),2f);
            varianza = varianza + rango;
        }
        varianza = varianza / cantidad;
        desviacion = Math.sqrt(varianza);
        dataExternal.promedio = (ed*1.0)/cantidad;
        dataExternal.desviacion = desviacion;
        return dataExternal;
    }


}

