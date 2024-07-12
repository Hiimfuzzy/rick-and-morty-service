package com.hexagonal;

import com.hexagonal.services.CharacterService;
import com.hexagonal.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication implements ApplicationRunner {

    @Autowired
    private CharacterUseCase characterUseCase;
    @Autowired
    private LocationUseCase locationUseCase;

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception{
        characterUseCase.executeFetchAndSaveAllCharacters();
        locationUseCase.executeFetchAndSaveAllLocations();
    }
}