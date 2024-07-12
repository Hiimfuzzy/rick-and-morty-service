package com.hexagonal.services;

import com.hexagonal.entities.Character;
import com.hexagonal.repositories.CharacterRepository;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }

    public List<Character> getAllCharacters(){
        return characterRepository.findAll();
    }

    public Character getCharacter(Long id){
        return characterRepository.findById(id).orElse(null);
    }
    public Character createCharacter(Character character) {
        return characterRepository.save(character);
    }

    public Character updateCharacter (Long id, Character character){
        return characterRepository.findById(id)
                .map(existingCharacter -> {
                    existingCharacter.setName(character.getName());
                    existingCharacter.setStatus(character.getStatus());
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
