package com.br.microservice.pedido.entity;

import com.br.microservice.pedido.enums.TipoPagamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;
@Slf4j
@Data
@Entity
@Table(name = "Comanda")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Comanda {




        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private LocalDateTime data;

        @Column(nullable = false)
        private double conta;

        @Column(nullable = false)
        private TipoPagamento tipoPagamento;

        @ManyToOne(cascade = CascadeType.PERSIST)
        @JoinColumn(name = "cliente_id")
        private Cliente cliente;

        private boolean isPago = false;

    }
