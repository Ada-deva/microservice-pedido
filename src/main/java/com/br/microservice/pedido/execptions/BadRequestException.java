package com.br.microservice.pedido.execptions;

public class BadRequestException extends Exception {

    public BadRequestException(String mensagem) {
        super(mensagem);
    }

}
