package com.hexagonal.usecases.impl;

import com.hexagonal.entities.Location;
import com.hexagonal.services.LocationService;
import com.hexagonal.usecases.LocationUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationUseCaseImpl implements LocationUseCase {
    private final LocationService locationService;

    public LocationUseCaseImpl(LocationService locationService) {
        this.locationService = locationService;
    }


    @Override
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @Override
    public Location getLocation(Long id) {
        return locationService.getLocation(id);
    }

    @Override
    public Location createLocation(Location location) {
        return locationService.createLocation(location);
    }

    @Override
    public Location updateCharacter(Long id, Location location) {
        return locationService.updateLocation(id, location);
    }

    @Override
    public boolean deleteLocation(Long id) {
        return locationService.deleteLocation(id);
    }
}
