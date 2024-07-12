package com.hexagonal;


import com.hexagonal.entities.dto.PersonaDto;
import com.hexagonal.entities.models.Persona;
import com.hexagonal.services.CharacterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterUseCase {
    private final CharacterService characterService;

    public void executeFetchAndSaveAllCharacters() {
        characterService.fetchAndSaveAllCharacters();
    }

    public CharacterUseCase(CharacterService characterService){
        this.characterService = characterService;
    }


    public List<PersonaDto> getAllCharacters(){
        return characterService.getAllCharacters();
    }


    public Persona getCharacter(Long id){
        return characterService.getCharacter(id);
    }


    public Persona createCharacter(Persona character){
        return characterService.createCharacter(character);
    }


    public Persona updateCharacter(Long id, Persona character){
        return characterService.updateCharacter(id, character);
    }


    public boolean deleteCharacter(Long id) {
        return characterService.deleteCharacter(id);
    }
}
