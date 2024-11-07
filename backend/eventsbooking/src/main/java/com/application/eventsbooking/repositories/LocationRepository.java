package com.application.eventsbooking.repositories;

import com.application.eventsbooking.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    Location findById(int id);

}
