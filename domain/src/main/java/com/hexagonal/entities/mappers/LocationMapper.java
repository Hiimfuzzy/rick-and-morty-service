package com.hexagonal.entities.mappers;

import com.hexagonal.entities.dto.LocationDto;
import com.hexagonal.entities.models.Location;

public interface LocationMapper {
    LocationDto toLocationDto(Location location);
    Location toLocation(LocationDto locationDto);
}
