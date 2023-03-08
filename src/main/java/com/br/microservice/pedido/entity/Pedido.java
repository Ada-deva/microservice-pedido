package com.br.microservice.pedido.entity;

import com.br.microservice.pedido.DTO.MenuDTO;
import com.br.microservice.pedido.enums.TipoPagamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@Data
@Entity
@Table(name = "Pedido")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Pedido {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private List<MenuDTO> listaMenuDTO;

    private Comanda comanda;

    @Min(value = 1,message = "O valor minimo do pedido é de 10,00")
    private Double valorTotalPedido;

}
