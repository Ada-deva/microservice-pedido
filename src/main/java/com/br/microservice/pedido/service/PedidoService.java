package com.br.microservice.pedido.service;

import com.br.microservice.pedido.model.Cliente;
import com.br.microservice.pedido.model.ItemMenu;
import com.br.microservice.pedido.model.ItemPedido;
import com.br.microservice.pedido.model.Pedido;
import com.br.microservice.pedido.payloads.PedidoRequest;
import com.br.microservice.pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PedidoService {
    private final CreatePedidoService createPedidoService;
    private final CreateClienteService createClienteService;
    private final CreateOrRetrieveProdutoService createOrRetrieveProdutoService;


    public void salvar(PedidoRequest pedidoRequest) {

        Cliente cliente = salvarCliente(pedidoRequest);
        ItemMenu itemMenu = salvarItemMenu(pedidoRequest);
        Pedido pedido = salvarPedido(pedidoRequest, itemMenu, cliente);

       // enviarPedidoToFinanceiro(cliente, itemMenu, pedido);
    }


    private Pedido salvarPedido(PedidoRequest pedidoRequest, ItemMenu itemMenu, Cliente cliente) {
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);


        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setQuantidade(pedidoRequest.getQuantidade());
        itemPedido.setItem(itemMenu);
        itemPedido.getItem().setPreco(pedidoRequest.getPrecoVenda());
        return createPedidoService.executar(pedido, List.of(itemPedido));

    }

    private ItemMenu salvarItemMenu(PedidoRequest pedidoRequest) {
        ItemMenu itemMenu = new ItemMenu();
        itemMenu.setPreco(pedidoRequest.getPrecoVenda());
        itemMenu.setNome(pedidoRequest.getNome());
        return createOrRetrieveProdutoService.execute(itemMenu);
    }

    private Cliente salvarCliente(PedidoRequest pedidoRequest) {
        Cliente cliente = new Cliente();
        cliente.setNome(pedidoRequest.getCliente().getNome());
        cliente.setCpf(pedidoRequest.getCliente().getCpf());
        return createClienteService.executar(cliente);
    }


}
