package com.br.microservice.pedido.service;

import com.br.microservice.pedido.model.ItemPedido;
import com.br.microservice.pedido.model.ItemPedidoComposedKey;
import com.br.microservice.pedido.model.Pedido;
import com.br.microservice.pedido.repository.ItemPedidoRepository;
import com.br.microservice.pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CreatePedidoService {

    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;
    public Pedido executar(Pedido pedido, List<ItemPedido> itemPedidos){
        Pedido salvarPedido= pedidoRepository.save(pedido);
        itemPedidos
                .forEach(itemPedido ->
                        itemPedido.setItemPedidoComposedKey
                                (new ItemPedidoComposedKey(salvarPedido.getId(),itemPedido.getItem().getId())));
        itemPedidoRepository.saveAll(itemPedidos);
        salvarPedido.setItemPedidoList(itemPedidos);
        return salvarPedido;
    }
}
