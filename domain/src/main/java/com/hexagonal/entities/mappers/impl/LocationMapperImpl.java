package com.hexagonal.entities.mappers.impl;

import com.hexagonal.entities.dto.LocationDto;
import com.hexagonal.entities.dto.PersonaDto;
import com.hexagonal.entities.mappers.LocationMapper;
import com.hexagonal.entities.mappers.PersonaMapper;
import com.hexagonal.entities.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocationMapperImpl implements LocationMapper {

    private final PersonaMapper personaMapper;

    @Autowired
    public LocationMapperImpl(PersonaMapper personaMapper) {
        this.personaMapper = personaMapper;
    }
    @Override
    public LocationDto toLocationDto(Location location) {
        List<String> residentIdentifiers = location.getResidents();
        return new LocationDto(location.getId(), location.getName(),
                location.getType(), location.getDimension(),
                residentIdentifiers, location.getUrl(), location.getCreated());
    }

    @Override
    public Location toLocation(LocationDto locationDto) {
        Location location = new Location();
        location.setId(locationDto.getId());
        location.setName(locationDto.getName());
        location.setType(locationDto.getType());
        location.setDimension(locationDto.getDimension());
        location.setResidents(locationDto.getResidents());
        location.setUrl(locationDto.getUrl());
        location.setCreated(locationDto.getCreated());
        return location;
    }
}
