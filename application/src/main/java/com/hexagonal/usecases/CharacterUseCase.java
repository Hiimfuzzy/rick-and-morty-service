package com.hexagonal.usecases;

import com.hexagonal.entities.Persona;

import java.util.List;

public interface CharacterUseCase {
    List<Persona> getAllCharacters();

    Persona getCharacter(Long id);

    Persona createCharacter(Persona character);

    Persona updateCharacter(Long id, Persona character);

    boolean deleteCharacter(Long id);
}
