package com.hexagonal.entities.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class PersonaDto {
    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private OriginDto origin;
    private LocationDetailsDto location;
    private String image;
    private List<EpisodeDto> episodes;
    private List<String> residents;

    public PersonaDto(Long id, String name, String status, String species, String type, String gender, OriginDto origin, LocationDetailsDto location, String image, List<EpisodeDto> episodes, List<String> residents) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.species = species;
        this.type = type;
        this.gender = gender;
        this.origin = origin;
        this.location = location;
        this.image = image;
        this.episodes = episodes;
        this.residents = residents;
    }
}
