package com.pragma.powerup.usermicroservice.config.converters.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl.UserHandlerImpl;
import com.pragma.powerup.usermicroservice.config.converters.IJsonConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JsonConverterImpl implements IJsonConverter {
    private final static Logger logger = LoggerFactory.getLogger(UserHandlerImpl.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String jsonConverters(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error("Error al serializar el objeto JSON: " + e.getMessage());
        }
        return null;
    }

    @Override
    public String jsonNodeConverters(String value, Object object) {
        ObjectNode jsonNode = objectMapper.createObjectNode();
        jsonNode.putPOJO(value, object);
        try {
            return objectMapper.writeValueAsString(jsonNode);
        } catch (JsonProcessingException e) {
            logger.error("Error al serializar el objeto JSON: " + e.getMessage());
        }
        return null;
    }
}
