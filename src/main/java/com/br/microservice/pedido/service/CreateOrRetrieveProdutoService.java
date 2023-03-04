package com.br.microservice.pedido.service;

import com.br.microservice.pedido.model.ItemMenu;
import com.br.microservice.pedido.repository.ItemMenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateOrRetrieveProdutoService {


    private final ItemMenuRepository itemMenuRepository;

    public ItemMenu execute(ItemMenu itemMenu) {
        itemMenu.setIdentificador(UUID.randomUUID().toString());
        return itemMenuRepository.findByNome(itemMenu.getNome()).orElse(itemMenuRepository.save(itemMenu));
    }

}

