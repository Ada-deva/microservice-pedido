package com.br.microservice.pedido.Repository;

import com.br.microservice.pedido.entity.Insumo;
import org.springframework.data.repository.CrudRepository;

public interface InsumoRepository extends CrudRepository<Insumo, Long> {
}