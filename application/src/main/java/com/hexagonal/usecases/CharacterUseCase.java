package com.hexagonal.usecases;

import com.hexagonal.entities.Character;
import com.hexagonal.services.CharacterService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CharacterUseCase {
    private final CharacterService characterService;

    public CharacterUseCase (CharacterService characterService){
        this.characterService = characterService;
    }

    public List<Character> getAllCharacters(){
        return characterService.getAllCharacters();
    }

    public Character getCharacter(Long id){
        return characterService.getCharacter(id);
    }

    public Character createCharacter(Character character){
        return characterService.createCharacter(character);
    }

    public Character updateCharacter(Long id, Character character){
        return characterService.updateCharacter(id, character);
    }

    public boolean deleteCharacter(Long id) {
        return characterService.deleteCharacter(id);
    }
}
