package com.application.eventsbooking.services;

import com.application.eventsbooking.dto.BusinessEntityDetailsDTO;
import com.application.eventsbooking.models.BusinessEntity;
import com.application.eventsbooking.models.Role;
import com.application.eventsbooking.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements BusinessEntityService{

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Role getRole() {
        return Role.USER;
    }



    @Override
    public BusinessEntityDetailsDTO getBusinessEntityByUserId(int id) {
        BusinessEntity entity = companyRepository.findByUserId(id);

        return null;
    }
}
