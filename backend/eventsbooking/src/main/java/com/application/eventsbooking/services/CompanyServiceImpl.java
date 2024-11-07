package com.application.eventsbooking.services;

import com.application.eventsbooking.models.BusinessEntity;
import com.application.eventsbooking.models.Role;

public class CompanyServiceImpl implements BusinessEntityService{
    @Override
    public Role getRole() {
        return Role.USER;
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
