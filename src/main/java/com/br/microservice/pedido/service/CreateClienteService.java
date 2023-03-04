package com.br.microservice.pedido.service;

import com.br.microservice.pedido.model.Cliente;
import com.br.microservice.pedido.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateClienteService {

    private final ClienteRepository clienteRepository;
    public Cliente executar(Cliente cliente){
        cliente.setIdentificador(UUID.randomUUID().toString());
        log.info("Cliente de ID {}",cliente.getIdentificador());
        return clienteRepository.findByCpf(cliente.getCpf())
                .orElse(clienteRepository.save(cliente));

    }
}
