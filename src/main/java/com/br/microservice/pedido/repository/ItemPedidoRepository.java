package com.br.microservice.pedido.repository;

import com.br.microservice.pedido.model.ItemPedido;
import com.br.microservice.pedido.model.ItemPedidoComposedKey;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoComposedKey> {
}
