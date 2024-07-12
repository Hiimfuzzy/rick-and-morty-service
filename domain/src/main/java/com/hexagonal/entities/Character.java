package com.hexagonal.entities;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Character {
    @Id
    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private String origin;
    private String location;
    private String image;
    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> episodes;
}
