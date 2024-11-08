package com.application.eventsbooking.services;

import com.application.eventsbooking.Mapper.LocationMapper;
import com.application.eventsbooking.Mapper.VendorMapper;
import com.application.eventsbooking.dto.LocationDTO;
import com.application.eventsbooking.models.Location;
import com.application.eventsbooking.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }

    @Override
    public LocationDTO addLocation(LocationDTO locationDTO) {
        try {
            Location locationEntity = locationMapper.toEntity(locationDTO);
            locationEntity = locationRepository.save(locationEntity);

            return locationMapper.toDTO(locationEntity);

        }catch (Exception e){
            throw new RuntimeException("Error while adding location.");
        }

    }

    @Override
    public LocationDTO getLocation(int id) {
        try {
            Location locationEntity = locationRepository.findById(id);

            return locationMapper.toDTO(locationEntity);
        }catch (Exception e){
            throw new RuntimeException("Error while getting location.");
        }
    }

    @Override
    public List<LocationDTO> getAllLocations() {
        List<Location> locations = locationRepository.findAll();

        if (locations.isEmpty()) {
            return Collections.emptyList();
        }
        return locations.stream()
                .map(location -> {
                    try {
                        return locationMapper.toDTO(location);
                    } catch (Exception e) {
                        // handle mapping exception
                        throw new IllegalStateException("Error mapping Location to DTO", e);
                    }
                })
                .collect(Collectors.toList());
    }
}
