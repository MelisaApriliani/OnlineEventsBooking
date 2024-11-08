package com.application.eventsbooking.services;

import com.application.eventsbooking.dto.LocationDTO;
import com.application.eventsbooking.models.Location;

import java.util.List;

public interface LocationService {
    public LocationDTO addLocation(LocationDTO location);
    public LocationDTO getLocation(int id);
    public List<LocationDTO> getAllLocations();
}
