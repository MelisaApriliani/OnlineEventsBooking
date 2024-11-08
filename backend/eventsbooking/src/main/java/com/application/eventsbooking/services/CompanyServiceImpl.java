package com.application.eventsbooking.services;

import com.application.eventsbooking.Mapper.BusinessEntityMapper;
import com.application.eventsbooking.dto.BusinessEntityDetailsDTO;
import com.application.eventsbooking.models.Company;
import com.application.eventsbooking.models.Role;
import com.application.eventsbooking.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements BusinessEntityService{

    private final CompanyRepository companyRepository;
    private final BusinessEntityMapper businessEntityMapper;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, BusinessEntityMapper businessEntityMapper) {
        this.companyRepository = companyRepository;
        this.businessEntityMapper = businessEntityMapper;
    }

    @Override
    public Role getRole() {
        return Role.USER;
    }

    @Override
    public BusinessEntityDetailsDTO getBusinessEntityByUserId(int id) {
        Company company = companyRepository.findByUserId(id);

        if (company == null) {
            throw new RuntimeException("Vendor with id is not found.");
        }
        try {
            return businessEntityMapper.toDTO(company);
        }catch (Exception e){
            throw new IllegalStateException("Error mapping Vendor to DTO", e);
        }
    }
}
