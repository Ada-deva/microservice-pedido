package com.br.microservice.pedido.Repository;

import com.br.microservice.pedido.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}


