package com.hexagonal.services;

import com.hexagonal.LocationDataProvider;
import com.hexagonal.entities.dto.LocationDto;
import com.hexagonal.entities.mappers.LocationMapper;
import com.hexagonal.entities.models.Location;
import com.hexagonal.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {
    private final LocationRepository locationRepository;
    private final LocationDataProvider apiAdapter;

    @Autowired
    private LocationMapper locationMapper;


    @Autowired
    public LocationService(LocationRepository locationRepository, LocationDataProvider apiAdapter) {
        this.locationRepository = locationRepository;
        this.apiAdapter = apiAdapter;
    }

    public void fetchAndSaveAllLocations() {
        List<LocationDto> locationDtos = apiAdapter.fetchAllLocations();
        List<Location> locations = locationDtos.stream()
                .map(locationMapper::toLocation)
                .collect(Collectors.toList());
        locationRepository.saveAll(locations);
    }


    public List<LocationDto> getAllLocations() {
        return locationRepository.findAll().stream()
                .map(locationMapper::toLocationDto)
                .collect(Collectors.toList());
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
