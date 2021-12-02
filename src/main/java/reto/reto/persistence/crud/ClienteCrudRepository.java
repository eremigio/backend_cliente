package reto.reto.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import reto.reto.persistence.entity.Cliente;

public interface ClienteCrudRepository extends CrudRepository<Cliente,Integer> {
}
