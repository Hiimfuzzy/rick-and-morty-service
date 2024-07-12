package com.hexagonal.repositories;

import com.hexagonal.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CharacterRepository extends JpaRepository <Persona, Long> {
}
