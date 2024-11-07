package com.application.eventsbooking.repositories;

import com.application.eventsbooking.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Company findById(int id);
    Company findByUserId(int userId);
}
