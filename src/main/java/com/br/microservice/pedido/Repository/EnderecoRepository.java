package com.br.microservice.pedido.Repository;

import com.br.microservice.pedido.entity.Endereco;
import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
}

