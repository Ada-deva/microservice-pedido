package com.br.microservice.pedido.execptions;

public class InformacaoInvalidaException extends Throwable {
    public InformacaoInvalidaException(String mensagem) {

            super(mensagem);

    }
}
