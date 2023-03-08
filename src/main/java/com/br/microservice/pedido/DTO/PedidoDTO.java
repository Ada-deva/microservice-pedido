package com.br.microservice.pedido.DTO;

import com.br.microservice.pedido.entity.Comanda;
import com.br.microservice.pedido.entity.Pedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private long id;

    private List<MenuDTO> listaMenu;

    private Comanda comanda;

    private Double valorTotalPedido;

    public PedidoDTO of (Pedido pedido){
        return PedidoDTO.builder()
                .id(pedido.getId())
                .listaMenu(pedido.getListaMenuDTO())
                .comanda(pedido.getComanda())
                .valorTotalPedido(pedido.getValorTotalPedido())
                .build();
    }

    public Pedido toEntity (){

        Pedido.builder()
                .valorTotalPedido(valorTotalPedido)
                .listaMenuDTO(listaMenu)
                .id(id)
                .comanda(comanda)
                .build();
    }
}
