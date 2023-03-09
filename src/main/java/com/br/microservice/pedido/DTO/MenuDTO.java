package com.br.microservice.pedido.DTO;

import com.br.microservice.pedido.entity.Menu;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {

    @NonNull
    private String descricao;

    @NonNull
    private int quantidade;
    @NonNull
    private Double valor;

    public MenuDTO of (Menu menu, MenuDTO menuDTO){
        return MenuDTO.builder()
                .descricao(menu.getDescricao())
                .valor(menu.getValor())
                .quantidade(menuDTO.getQuantidade())
                .build();
    }

    public Menu toEntity (){
        return Menu.builder()
                .descricao(descricao)
                .valor(valor)
                .build();
    }
}