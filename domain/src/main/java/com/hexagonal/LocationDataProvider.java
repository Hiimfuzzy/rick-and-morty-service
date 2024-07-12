package com.hexagonal;

import com.hexagonal.entities.dto.LocationDto;
import com.hexagonal.entities.models.Location;

import java.util.List;

public interface LocationDataProvider {
    List<LocationDto> fetchAllLocations();
}
