package com.application.eventsbooking.repositories;

import com.application.eventsbooking.models.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
    Vendor findById(int id);
    Vendor findByUserId(int userId);
}
