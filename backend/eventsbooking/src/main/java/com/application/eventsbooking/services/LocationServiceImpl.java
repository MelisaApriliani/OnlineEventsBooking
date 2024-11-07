package com.application.eventsbooking.services;

import com.application.eventsbooking.models.Location;
import com.application.eventsbooking.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location getLocation(int id) {
        return locationRepository.findById(id);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
