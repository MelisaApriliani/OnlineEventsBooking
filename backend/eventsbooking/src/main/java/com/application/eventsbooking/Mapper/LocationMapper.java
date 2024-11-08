package com.application.eventsbooking.Mapper;

import com.application.eventsbooking.dto.LocationDTO;
import com.application.eventsbooking.models.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {
    public LocationDTO toDTO(Location location) {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(location.getId());
        locationDTO.setName(location.getName());
        locationDTO.setAddress(location.getAddress());
        locationDTO.setPostalCode(location.getPostalCode());

        return locationDTO;
    }

    public Location toEntity(LocationDTO locationDTO) {
        Location location = new Location();
        location.setId(locationDTO.getId());
        location.setName(locationDTO.getName());
        location.setAddress(locationDTO.getAddress());
        location.setPostalCode(locationDTO.getPostalCode());

        return location;
    }
}
