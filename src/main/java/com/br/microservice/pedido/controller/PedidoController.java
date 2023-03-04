package com.br.microservice.pedido.controller;

import com.br.microservice.pedido.payloads.PedidoRequest;
import com.br.microservice.pedido.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("pedido")
public class PedidoController {
    private final  PedidoService pedidoService;

    @PostMapping
    public void salvar(@RequestBody PedidoRequest pedidoRequest){
        pedidoService.salvar(pedidoRequest);
    }

}
