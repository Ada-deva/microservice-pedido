package com.br.microservice.pedido.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PedidoRequest {
    private String nome;
    @JsonProperty(value = "preco_venda")
    private double precoVenda;
    private int quantidade;
    private ClienteRequest cliente;
}
