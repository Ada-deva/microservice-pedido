package com.br.microservice.pedido.payloads;

import lombok.Data;

@Data
public class ClienteRequest {
    private String identificador;

    private String cpf;
    private String nome;

}
