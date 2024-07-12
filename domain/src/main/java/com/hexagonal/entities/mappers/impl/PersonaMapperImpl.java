package com.hexagonal.entities.mappers.impl;

import com.hexagonal.entities.dto.*;
import com.hexagonal.entities.mappers.PersonaMapper;
import com.hexagonal.entities.models.Episode;
import com.hexagonal.entities.models.LocationDetails;
import com.hexagonal.entities.models.Origin;
import com.hexagonal.entities.models.Persona;
import com.hexagonal.repositories.CharacterRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonaMapperImpl implements PersonaMapper {
    private final CharacterRepository characterRepository;

    public PersonaMapperImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public PersonaDto toPersonaDto(Persona persona) {
        OriginDto originDto = new OriginDto();
        if (persona.getOrigin() != null) {
            originDto.setName(persona.getOrigin().getName());
            originDto.setUrl(persona.getOrigin().getUrl());
        }
        LocationDetailsDto locationDetailsDto = new LocationDetailsDto();
        if (persona.getLocation() != null) {
            locationDetailsDto.setName(persona.getLocation().getName());
            locationDetailsDto.setUrl(persona.getLocation().getUrl());
        }

        List<EpisodeDto> episodeDtos;
        if (persona.getEpisodes() != null) {
            episodeDtos = persona.getEpisodes().stream().map(episode -> {
                EpisodeDto episodeDto = new EpisodeDto();
                episodeDto.setTitle(episode.getTitle());
                episodeDto.setCharacter(episode.getCharacter() != null ? episode.getCharacter().getName() : null);
                return episodeDto;
            }).collect(Collectors.toList());
        } else {
            episodeDtos = new ArrayList<>();
        }
        return new PersonaDto(persona.getId(),
                persona.getName(),
                persona.getStatus(),
                persona.getSpecies(),
                persona.getType(),
                persona.getGender(),
                originDto,
                locationDetailsDto,
                persona.getImage(),
                episodeDtos, persona.getResidents());
    }

    @Override
    public Persona toPersona(PersonaDto personaDto) {
        Persona persona = new Persona();
        persona.setId(personaDto.getId());
        persona.setName(personaDto.getName());
        persona.setStatus(personaDto.getStatus());
        persona.setSpecies(personaDto.getSpecies());
        persona.setType(personaDto.getType());
        persona.setGender(personaDto.getGender());
        persona.setImage(personaDto.getImage());

        Origin origin = new Origin();
        origin.setName(personaDto.getOrigin().getName());
        origin.setUrl(personaDto.getOrigin().getUrl());
        persona.setOrigin(origin);

        LocationDetails location = new LocationDetails();
        location.setName(personaDto.getLocation().getName());
        location.setUrl(personaDto.getLocation().getUrl());
        persona.setLocation(location);

        List<Episode> episodes = personaDto.getEpisodes().stream()
                .map(this::toEpisode)
                .collect(Collectors.toList());
        persona.setEpisodes(episodes);
        return persona;
    }

    private Episode toEpisode(EpisodeDto episodeDto) {
        Episode episode = new Episode();
        episode.setTitle(episodeDto.getTitle());
        String characterNameLowercase = episodeDto.getCharacter().toLowerCase();
        Persona character = (Persona) characterRepository.findByName(characterNameLowercase).orElse(null);
        episode.setCharacter(character);
        return episode;
    }
}
