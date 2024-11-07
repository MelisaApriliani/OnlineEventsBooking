package com.application.eventsbooking.services;

import com.application.eventsbooking.models.BusinessEntity;
import com.application.eventsbooking.models.Company;
import com.application.eventsbooking.models.Role;
import com.application.eventsbooking.models.Vendor;
import com.application.eventsbooking.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements BusinessEntityService{

    private final VendorRepository vendorRepository;

    @Autowired
    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }


    @Override
    public Role getRole() {
        return Role.ADMIN;
    }

    @Override
    public BusinessEntity createBusinessEntity(BusinessEntity businessEntity) {
        if (businessEntity instanceof Vendor) {
            return vendorRepository.save((Vendor) businessEntity);
        }
        throw new IllegalArgumentException("Invalid entity type for CompanyService");
    }

    @Override
    public BusinessEntity updateBusinessEntity(BusinessEntity businessEntity) {
        if (businessEntity instanceof Vendor) {
            return vendorRepository.save((Vendor) businessEntity);
        }
        throw new IllegalArgumentException("Invalid entity type for CompanyService");
    }

    @Override
    public BusinessEntity getBusinessEntityByUserId(int id) {
        return vendorRepository.findByUserId(id);
    }
}
