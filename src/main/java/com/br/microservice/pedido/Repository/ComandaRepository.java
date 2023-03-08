package com.br.microservice.pedido.Repository;

import com.br.microservice.pedido.entity.Comanda;
import org.springframework.data.repository.CrudRepository;

public interface ComandaRepository extends CrudRepository<Comanda, Long> {
}
