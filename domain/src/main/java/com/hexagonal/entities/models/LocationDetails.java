package com.hexagonal.entities.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDetails {
    private String name;
    @JsonIgnore
    private String url;

}
