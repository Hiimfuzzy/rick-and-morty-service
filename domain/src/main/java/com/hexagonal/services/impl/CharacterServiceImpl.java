package com.hexagonal.services.impl;

import com.hexagonal.entities.Location;
import com.hexagonal.entities.Persona;
import com.hexagonal.repositories.CharacterRepository;
import com.hexagonal.repositories.LocationRepository;
import com.hexagonal.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public CharacterServiceImpl(CharacterRepository characterRepository, LocationRepository locationRepository){
        this.characterRepository = characterRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Persona> getAllCharacters(){
        return characterRepository.findAll();
    }

    @Override
    public Persona getCharacter(Long id){
        return characterRepository.findById(id).orElse(null);
    }
    @Override
    public Persona createCharacter(Persona character) {
        return characterRepository.save(character);
    }

    @Override
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

                    Location location = locationRepository.findByName(character.getLocation()).orElse(null);
                    if (location != null && !existingCharacter.getLocations().contains(location)) {
                        existingCharacter.getLocations().add(location);
                    }

                    return characterRepository.save(existingCharacter);
                }).orElse(null);
    }


    @Override
    public boolean deleteCharacter(Long id) {
        if(characterRepository.existsById(id)){
            characterRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
