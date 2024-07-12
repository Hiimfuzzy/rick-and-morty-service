package com.hexagonal.api;

import com.hexagonal.CharacterDataProvider;
import com.hexagonal.LocationDataProvider;
import com.hexagonal.configuration.JsonProcessingService;
import com.hexagonal.entities.dto.LocationDto;
import com.hexagonal.entities.dto.PersonaDto;
import com.hexagonal.entities.mappers.LocationMapper;
import com.hexagonal.entities.mappers.PersonaMapper;
import com.hexagonal.entities.models.Location;
import com.hexagonal.entities.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RickAndMortyApiAdapter implements CharacterDataProvider, LocationDataProvider {
    private static final String API_URL = "https://rickandmortyapi.com/api";

    private final RestTemplate restTemplate;
    private final PersonaMapper personaMapper;
    private final LocationMapper locationMapper;
    private final JsonProcessingService jsonProcessingService;

    @Autowired
    public RickAndMortyApiAdapter(RestTemplate restTemplate, PersonaMapper personaMapper, LocationMapper locationMapper, JsonProcessingService jsonProcessingService) {
        this.restTemplate = restTemplate;
        this.personaMapper = personaMapper;
        this.locationMapper = locationMapper;
        this.jsonProcessingService = jsonProcessingService;
    }

    @Override
    public List<PersonaDto> fetchAllCharacters() {
        ResponseEntity<String> responseEntity = restTemplate.exchange(API_URL + "/character", HttpMethod.GET, null, String.class);
        String jsonResponse = responseEntity.getBody();
        try {
            ResponseWrapper<Persona> response = jsonProcessingService.deserializePersonaResponse(jsonResponse);
            return response.getResults().stream()
                    .map(personaMapper::toPersonaDto)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to deserialize response", e);
        }
    }

    @Override
    public List<LocationDto> fetchAllLocations() {
        String jsonResponse = restTemplate.getForObject(API_URL + "/location", String.class);
        try {
            ResponseWrapper<Location> response = jsonProcessingService.deserializeLocationResponse(jsonResponse);
            return response.getResults().stream()
                    .map(locationMapper::toLocationDto)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to deserialize location response", e);
        }
    }
}
