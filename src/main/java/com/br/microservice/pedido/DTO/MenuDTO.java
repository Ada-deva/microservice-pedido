package com.br.microservice.pedido.DTO;

import com.br.microservice.pedido.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {

    private String descricao;

    private Double valor;

    public MenuDTO of (Menu menu){
        return MenuDTO.builder()
                .descricao(menu.getDescricao())
                .valor(menu.getValor())
                .build();
    }

    public Menu toEntity (){
        Menu.builder()
                .descricao(descricao)
                .valor(valor)
                .build();
    }
}