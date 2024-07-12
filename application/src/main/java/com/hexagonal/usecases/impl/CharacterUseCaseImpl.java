package com.hexagonal.usecases.impl;

import com.hexagonal.entities.Persona;
import com.hexagonal.services.CharacterService;
import com.hexagonal.usecases.CharacterUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterUseCaseImpl implements CharacterUseCase {
    private final CharacterService characterService;

    public CharacterUseCaseImpl(CharacterService characterService){
        this.characterService = characterService;
    }

    @Override
    public List<Persona> getAllCharacters(){
        return characterService.getAllCharacters();
    }

    @Override
    public Persona getCharacter(Long id){
        return characterService.getCharacter(id);
    }

    @Override
    public Persona createCharacter(Persona character){
        return characterService.createCharacter(character);
    }

    @Override
    public Persona updateCharacter(Long id, Persona character){
        return characterService.updateCharacter(id, character);
    }

    @Override
    public boolean deleteCharacter(Long id) {
        return characterService.deleteCharacter(id);
    }
}
