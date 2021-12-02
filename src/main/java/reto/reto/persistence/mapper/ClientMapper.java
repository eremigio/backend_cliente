package reto.reto.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import reto.reto.domain.Client;
import reto.reto.persistence.entity.Cliente;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mappings(
            {
                    @Mapping(source = "id",target = "id"),
                    @Mapping(source = "nombre",target = "name"),
                    @Mapping(source = "apellido",target = "lastname"),
                    @Mapping(source = "fechanacimiento",target = "datebirthday"),
                    @Mapping(source = "fechafallecimiento",target = "datedeath")
            }
    )
    Client toClient(Cliente client);
    @InheritInverseConfiguration
    Cliente toCliente(Client client);
    List<Client> toClients(List<Cliente> clientes);
}
