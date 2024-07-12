package com.hexagonal.repositories;

import com.hexagonal.entities.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface CharacterRepository extends JpaRepository <Character, Long> {
}
