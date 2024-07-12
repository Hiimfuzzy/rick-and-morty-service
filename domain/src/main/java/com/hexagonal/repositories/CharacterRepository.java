package com.hexagonal.repositories;

import com.hexagonal.entities.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository <Persona, Long> {
    Optional<Object> findByName(String character);
}
