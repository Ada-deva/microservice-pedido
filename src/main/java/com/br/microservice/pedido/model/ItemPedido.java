package com.br.microservice.pedido.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "item_Pedido")
public class ItemPedido {
    @EmbeddedId
    private ItemPedidoComposedKey itemPedidoComposedKey;
    @ManyToOne
    @JoinColumn(name = "id_item_menu", insertable = false, updatable = false)
    private ItemMenu item;
    @ManyToOne
    @JoinColumn(name = "id_pedido", insertable = false, updatable = false)
    private Pedido pedido;
    private double quantidade;

}
