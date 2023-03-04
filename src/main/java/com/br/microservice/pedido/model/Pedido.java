package com.br.microservice.pedido.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Data
@Entity
@Table(name = "Pedido")

public class Pedido {
    @Id
    @GeneratedValue
    private Long id;
    @CreatedDate
    private LocalDateTime dataCriacao;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @OneToMany//(mappedBy = "pedido")
    private List<ItemPedido> itemPedidoList;

}
