package com.hexagonal.entities.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "characters_id")
    private Persona character;

}
