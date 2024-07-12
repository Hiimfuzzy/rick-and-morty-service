package com.hexagonal.entities.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class LocationDto {
    private Long id;
    private String name;
    private String type;
    private String dimension;
    private List<String> residents;
    private String url;
    private String created;

    public LocationDto(Long id, String name, String type, String dimension, List<String> residents, String url, String created) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.dimension = dimension;
        this.residents = residents;
        this.url = url;
        this.created = created;
    }

}
