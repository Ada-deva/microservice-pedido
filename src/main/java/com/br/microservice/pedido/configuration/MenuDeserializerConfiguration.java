package com.br.microservice.pedido.configuration;

import com.br.microservice.pedido.DTO.MenuDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.context.annotation.Configuration;


import java.nio.charset.StandardCharsets;


@Configuration
@Slf4j
@RequiredArgsConstructor
public class MenuDeserializerConfiguration implements Deserializer<MenuDTO> {

        private final ObjectMapper objectMapper;

        @Override
        public MenuDeserializerConfiguration deserialize(String s, byte[] bytes) {
            log.info("Deserializando um objeto no tópico {}", s);
            String message = new String(bytes, StandardCharsets.UTF_8);
            try {
                return objectMapper.readValue(message, MenuDTO.class);
            } catch (JsonProcessingException e) {
                log.error("Não foi possível converter a mensagem no objeto desejado");
                return null;
            }

        }

        public MenuDeserializerConfiguration(){
            this.objectMapper = new ObjectMapper();
        }


}
