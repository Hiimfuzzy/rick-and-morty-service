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
public class Location {
    @Id
    private Long id;
    private String name;
    private String type;
    private String dimension;
    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> residents;
}
