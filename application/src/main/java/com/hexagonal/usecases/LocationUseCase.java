package com.hexagonal.usecases;

import com.hexagonal.entities.*;

import java.util.List;

public interface LocationUseCase {
    List<Location> getAllLocations();

    Location getLocation(Long id);

    Location createLocation(Location location);

    Location updateCharacter(Long id, Location location);

    boolean deleteLocation(Long id);
}
