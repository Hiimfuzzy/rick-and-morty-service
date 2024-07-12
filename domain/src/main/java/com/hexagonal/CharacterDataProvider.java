package com.hexagonal;

import com.hexagonal.entities.dto.PersonaDto;
import com.hexagonal.entities.models.Persona;

import java.util.List;

public interface CharacterDataProvider {
    List<PersonaDto> fetchAllCharacters();
}
