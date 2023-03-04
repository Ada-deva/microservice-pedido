package com.br.microservice.pedido.repository;

import com.br.microservice.pedido.model.ItemMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemMenuRepository extends JpaRepository<ItemMenu,Long> {
    Optional<ItemMenu> findByNome(String nome);
}
