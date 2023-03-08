package com.br.microservice.pedido.entity;

import com.br.microservice.pedido.enums.TipoItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Menu")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private TipoItem item;

    @Column(nullable = false)
    private String descricao;
    @OneToMany
    private List<Insumo> listaInsumo;

    @Column(nullable = false)
    private Double valor;


    }