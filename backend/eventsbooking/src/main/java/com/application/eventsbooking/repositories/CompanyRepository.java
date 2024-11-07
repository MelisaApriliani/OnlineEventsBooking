package com.application.eventsbooking.repositories;

import com.application.eventsbooking.models.BusinessEntity;
import com.application.eventsbooking.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    BusinessEntity findById(int id);
    BusinessEntity findByUserId(int userId);
}
