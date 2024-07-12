package com.hexagonal.repositories;

import com.hexagonal.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository <Location, Long> {
}
