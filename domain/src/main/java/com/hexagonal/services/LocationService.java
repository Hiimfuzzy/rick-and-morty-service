package com.hexagonal.services;

import com.hexagonal.entities.Character;
import com.hexagonal.entities.Location;
import com.hexagonal.repositories.LocationRepository;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;


    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocation(Long id) {
        return locationRepository.findById(id).orElse(null);
    }

    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location updateLocation(Long id, Location location) {
        return locationRepository.findById(id)
                .map(existingLocation -> {
                    existingLocation.setName(location.getName());
                    existingLocation.setType(location.getType());
                    existingLocation.setDimension(location.getDimension());
                    existingLocation.setResidents(location.getResidents());
                    return locationRepository.save(existingLocation);
                }).orElse(null);
    }

    public boolean deleteLocation(Long id) {
        if(locationRepository.existsById(id)) {
            locationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
