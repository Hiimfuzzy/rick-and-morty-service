package com.hexagonal.services;

import com.hexagonal.entities.Location;

import java.util.List;

public interface LocationService {
    List<Location> getAllLocations();
    Location getLocation(Long id);
    Location createLocation(Location location);
    Location updateLocation(Long id, Location location);
    boolean deleteLocation(Long id);
}
