package com.hexagonal.entities.mappers;

import com.hexagonal.entities.dto.PersonaDto;
import com.hexagonal.entities.models.Persona;

public interface PersonaMapper {
    PersonaDto toPersonaDto(Persona persona);
    Persona toPersona(PersonaDto personaDto);
}
