package com.br.microservice.pedido.DTO;

import com.br.microservice.pedido.entity.Comanda;
import com.br.microservice.pedido.enums.TipoPagamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComandaDTO {

    private long id;
    private LocalDateTime data;
    private double conta;
    private TipoPagamento tipoPagamento;
    private long cliente;
    private boolean isPago;

    public ComandaDTO of(Comanda comanda) {
        return ComandaDTO.builder()
                .id(comanda.getId())
                .data(comanda.getData())
                .conta(comanda.getConta())
                .tipoPagamento(comanda.getTipoPagamento())
                .cliente(comanda.getCliente().getId())
                .isPago(comanda.isPago())
                .build();
    }

    public Comanda toEntity() {
        return Comanda.builder()
                .id(id)
                .data(data)
                .conta(conta)
                .tipoPagamento(tipoPagamento)
                .isPago(isPago)
                .build();
    }
}
