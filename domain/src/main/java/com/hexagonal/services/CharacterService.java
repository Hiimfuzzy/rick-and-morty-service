package com.hexagonal.services;

import com.hexagonal.CharacterDataProvider;
import com.hexagonal.entities.dto.PersonaDto;
import com.hexagonal.entities.mappers.PersonaMapper;
import com.hexagonal.entities.models.Location;
import com.hexagonal.entities.models.Persona;
import com.hexagonal.repositories.CharacterRepository;
import com.hexagonal.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;
    private final LocationRepository locationRepository;
    private final CharacterDataProvider apiAdapter;

    @Autowired
    private PersonaMapper personaMapper;

    @Autowired
    public CharacterService(CharacterRepository characterRepository, LocationRepository locationRepository, CharacterDataProvider apiAdapter){
        this.characterRepository = characterRepository;
        this.locationRepository = locationRepository;
        this.apiAdapter = apiAdapter;
    }

    @Transactional
    public void fetchAndSaveAllCharacters(){
        List<PersonaDto> charactersDtos = apiAdapter.fetchAllCharacters();
        List<Persona> characters = charactersDtos.stream()
                .map(personaMapper::toPersona)
                .collect(Collectors.toList());
        characterRepository.saveAll(characters);
    }

    public List<PersonaDto> getAllCharacters(){
        return characterRepository.findAll().stream()
                .map(personaMapper::toPersonaDto)
                .collect(Collectors.toList());
    }


    public Persona getCharacter(Long id){
        return characterRepository.findById(id).orElse(null);
    }

    public Persona createCharacter(Persona character) {
        return characterRepository.save(character);
    }


    public Persona updateCharacter(Long id, Persona character) {
        return characterRepository.findById(id)
                .map(existingCharacter -> {
                    existingCharacter.setName(character.getName());
                    existingCharacter.setStatus(character.getStatus());
                    existingCharacter.setSpecies(character.getSpecies());
                    existingCharacter.setType(character.getType());
                    existingCharacter.setGender(character.getGender());
                    existingCharacter.setOrigin(character.getOrigin());
                    existingCharacter.setLocation(character.getLocation());
                    existingCharacter.setImage(character.getImage());
                    existingCharacter.setEpisodes(character.getEpisodes());

                    return characterRepository.save(existingCharacter);
                }).orElse(null);
    }


    public boolean deleteCharacter(Long id) {
        if(characterRepository.existsById(id)){
            characterRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

}
