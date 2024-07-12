package com.hexagonal.usecases;

import com.hexagonal.entities.Character;
import com.hexagonal.entities.Location;
import com.hexagonal.services.LocationService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocationUseCase {
    private final LocationService locationService;

    public LocationUseCase(LocationService locationService) {
        this.locationService = locationService;
    }


    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    public Location getLocation(Long id) {
        return locationService.getLocation(id);
    }

    public Location createLocation(Location location) {
        return locationService.createLocation(location);
    }

    public Location updateCharacter(Long id, Location location) {
        return locationService.updateLocation(id, location);
    }

    public boolean deleteLocation(Long id) {
        return locationService.deleteLocation(id);
    }
}
