package com.hexagonal.entities.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @JsonProperty("name")
    private String name;
    @JsonProperty("status")
    private String status;
    @JsonProperty("species")
    private String species;
    @JsonProperty("type")
    private String type;
    @JsonProperty("gender")
    private String gender;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "origin_name")),
            @AttributeOverride(name = "url", column = @Column(name = "origin_url"))
    })
    private Origin origin;
    @JsonProperty("location")
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "location_name")),
            @AttributeOverride(name = "url", column = @Column(name = "location_url"))
    })
    private LocationDetails location;
    @JsonProperty("image")
    private String image;
    @OneToMany(mappedBy = "character", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Episode> episodes;
    @ElementCollection
    private List<String> residents;


}
