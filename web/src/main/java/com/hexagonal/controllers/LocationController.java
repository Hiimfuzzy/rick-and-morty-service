package com.hexagonal.controllers;

import com.hexagonal.entities.Character;
import com.hexagonal.entities.Location;
import com.hexagonal.usecases.LocationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationUseCase locationUseCase;

    @Autowired
    public LocationController(LocationUseCase locationUseCase) {
        this.locationUseCase = locationUseCase;
    }

    @GetMapping
    public List<Location> getAllLocations(){
        return locationUseCase.getAllLocations();
    }

    @GetMapping("/{id}")
    public Location getLocation(@PathVariable Long id){
        return locationUseCase.getLocation(id);
    }

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location){
        Location createdLocation = locationUseCase.createLocation(location);
        if(createdLocation != null){
            return new ResponseEntity<>(createdLocation, HttpStatus.CREATED);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location location){
        Location updatedLocation = locationUseCase.updateCharacter(id, location);
        if(updatedLocation != null){
            return ResponseEntity.ok(updatedLocation);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation (@PathVariable Long id){
        boolean isDeleted = locationUseCase.deleteLocation(id);
        if(isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
