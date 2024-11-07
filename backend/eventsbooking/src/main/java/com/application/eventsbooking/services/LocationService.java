package com.application.eventsbooking.services;

import com.application.eventsbooking.models.Location;

import java.util.List;

public interface LocationService {
    public Location addLocation(Location location);
    public Location getLocation(int id);
    public List<Location> getAllLocations();
}
