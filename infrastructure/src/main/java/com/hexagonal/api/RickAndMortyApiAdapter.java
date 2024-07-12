package com.hexagonal.api;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class RickAndMortyApiAdapter {
    private static final String API_URL = "https://rickandmortyapi.com/api";

    private final RestTemplate restTemplate;

    public RickAndMortyApiAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Character> fetchCharacters(){
        Character[] characters = restTemplate.getForObject(API_URL + "/character", Character[].class);
        return Arrays.asList(characters);
    }
}
