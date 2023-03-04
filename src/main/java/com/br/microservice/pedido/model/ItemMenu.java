package com.br.microservice.pedido.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Item_Menu")
public class ItemMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String unidade;
    private double preco;
    private String identificador;
}

