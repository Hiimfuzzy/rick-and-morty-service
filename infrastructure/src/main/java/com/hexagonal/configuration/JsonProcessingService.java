package com.hexagonal.configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hexagonal.api.ResponseWrapper;
import com.hexagonal.entities.models.Location;
import com.hexagonal.entities.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JsonProcessingService {

    private final ObjectMapper objectMapper;

    @Autowired
    public JsonProcessingService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ResponseWrapper<Persona> deserializePersonaResponse(String jsonInput) throws JsonProcessingException {
        TypeReference<ResponseWrapper<Persona>> typeRef = new TypeReference<ResponseWrapper<Persona>>() {};
        return objectMapper.readValue(jsonInput, typeRef);
    }

    public ResponseWrapper<Location> deserializeLocationResponse(String jsonInput) throws JsonProcessingException {
        TypeReference<ResponseWrapper<Location>> typeRef = new TypeReference<ResponseWrapper<Location>>() {};
        return objectMapper.readValue(jsonInput, typeRef);
    }
}