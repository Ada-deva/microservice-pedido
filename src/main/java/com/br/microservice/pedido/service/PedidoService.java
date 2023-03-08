package com.br.microservice.pedido.service;


import com.br.microservice.pedido.DTO.ComandaDTO;
import com.br.microservice.pedido.DTO.PedidoDTO;
import com.br.microservice.pedido.Repository.ClienteRepository;
import com.br.microservice.pedido.Repository.ComandaRepository;
import com.br.microservice.pedido.Repository.PedidoRepository;
import com.br.microservice.pedido.entity.Cliente;
import com.br.microservice.pedido.entity.Comanda;
import com.br.microservice.pedido.entity.Pedido;
import com.br.microservice.pedido.execptions.BadRequestException;
import com.br.microservice.pedido.execptions.InformacaoNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private final ComandaRepository comandaRepository;
    @Autowired
    private final PedidoRepository pedidoRepository;
    @Autowired
    private final ClienteRepository clienteRepository;

    public Optional<Pedido> cadastrar(PedidoDTO pedidoDTO) throws InformacaoNaoEncontradaException {
        Optional<Cliente> clienteEncontrado = clienteRepository.findById(pedidoDTO.getComanda());
        Pedido novoPedido = pedidoDTO.toEntity();

        if (clienteEncontrado.isEmpty()) {
            throw new InformacaoNaoEncontradaException("Cliente não encontrado!");
        } else {
            clienteEncontrado.ifPresent(novaComanda::setCliente);
            novaComanda.setData(LocalDateTime.now());
            comandaRepository.save(novaComanda);
        }
        return Optional.of(novaComanda);
    }

    public List<Comanda> comandaList() {
        return (List<Comanda>) comandaRepository.findAll();
    }

    public Optional<Comanda> encontrarPorId(Long id) {
        return comandaRepository.findById(id);
    }

    public Optional<Comanda> atualizarComanda(ComandaDTO comanda, Long id) throws InformacaoNaoEncontradaException {
        Optional<Comanda> comandaEncontrada = comandaRepository.findById(id);
        if (comandaEncontrada.isPresent()) {
            if (comanda.getConta() != 0) {
                comandaEncontrada.get().setConta(comanda.getConta());
            }

            if (comanda.getTipoPagamento() != null) {
                comandaEncontrada.get().setTipoPagamento(comanda.getTipoPagamento());
            }

            if (comanda.getCliente() != 0) {
                Optional<Cliente> clienteEncontrado = clienteRepository.findById(comanda.getCliente());
                if (clienteEncontrado.isEmpty()) {
                    throw new InformacaoNaoEncontradaException("Cliente não encontrado!");
                } else {
                    comandaEncontrada.get().setCliente(clienteEncontrado.get());
                }
            }
            comandaRepository.save(comandaEncontrada.get());
        }

        return comandaEncontrada;
    }

    public Optional<Comanda> deletarComanda(Long id) {
        Optional<Comanda> comandaEncontrada = comandaRepository.findById(id);

        comandaEncontrada.ifPresent(comanda -> comandaRepository.delete(comanda));

        return comandaEncontrada;
    }

    public Optional<Comanda> pagarComanda(Long id) throws BadRequestException {
        Optional<Comanda> comandaEncontrada = comandaRepository.findById(id);
        if(comandaEncontrada.isPresent() && !comandaEncontrada.get().isPago()) {
            comandaEncontrada.get().setPago(true);
            return comandaEncontrada;
        } else {
            throw new BadRequestException("Comanda já está paga!");
        }
    }
}
