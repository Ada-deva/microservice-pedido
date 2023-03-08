package com.br.microservice.pedido.Repository;

import com.br.microservice.pedido.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
