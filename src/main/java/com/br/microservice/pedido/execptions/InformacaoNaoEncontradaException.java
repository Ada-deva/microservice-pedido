package com.br.microservice.pedido.execptions;

public class InformacaoNaoEncontradaException extends Exception {

    public InformacaoNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

}
