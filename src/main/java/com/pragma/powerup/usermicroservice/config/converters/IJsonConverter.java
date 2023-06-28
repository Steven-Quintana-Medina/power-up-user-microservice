package com.pragma.powerup.usermicroservice.config.converters;

public interface IJsonConverter {
    String jsonConverters(Object object);

    String jsonNodeConverters(String value, Object object);

}
