package com.application.eventsbooking.services;

import com.application.eventsbooking.models.BusinessEntity;
import com.application.eventsbooking.models.Role;

public class VendorServiceImpl implements BusinessEntityService{
    @Override
    public Role getRole() {
        return Role.ADMIN;
    }

    @Override
    public BusinessEntity createBusinessEntity(BusinessEntity businessEntity) {
        return null;
    }

    @Override
    public BusinessEntity updateBusinessEntity(BusinessEntity businessEntity) {
        return null;
    }

    @Override
    public BusinessEntity getBusinessEntityByUserId(int id) {
        return null;
    }
}
