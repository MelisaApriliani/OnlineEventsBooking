package com.application.eventsbooking.services;

import com.application.eventsbooking.models.BusinessEntity;
import com.application.eventsbooking.models.Company;
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
    public BusinessEntity createBusinessEntity(BusinessEntity businessEntity) {
        if (businessEntity instanceof Company) {
            return companyRepository.save((Company) businessEntity);
        }
        throw new IllegalArgumentException("Invalid entity type for CompanyService");
    }

    @Override
    public BusinessEntity updateBusinessEntity(BusinessEntity businessEntity) {
        if (businessEntity instanceof Company) {
            return companyRepository.save((Company) businessEntity);
        }
        throw new IllegalArgumentException("Invalid entity type for CompanyService");
    }

    @Override
    public BusinessEntity getBusinessEntityByUserId(int id) {
        return companyRepository.findByUserId(id);
    }
}
