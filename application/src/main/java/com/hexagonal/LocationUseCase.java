package com.hexagonal;

import com.hexagonal.entities.dto.LocationDto;
import com.hexagonal.entities.models.Location;
import com.hexagonal.services.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationUseCase {
    private final LocationService locationService;

    public void executeFetchAndSaveAllLocations() {
        locationService.fetchAndSaveAllLocations();
    }

    public LocationUseCase(LocationService locationService) {
        this.locationService = locationService;
    }


    public List<LocationDto> getAllLocations() {
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
