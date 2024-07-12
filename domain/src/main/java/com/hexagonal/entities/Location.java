package com.hexagonal.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String dimension;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "location_residents",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "resident_id")
    )
    private List<Character> residents;
}
