package com.application.eventsbooking.services;

import com.application.eventsbooking.models.BusinessEntity;
import com.application.eventsbooking.models.Role;

public interface BusinessEntityService {

    Role getRole();
    public BusinessEntity createBusinessEntity(BusinessEntity businessEntity);
    public BusinessEntity updateBusinessEntity(BusinessEntity businessEntity);
    public BusinessEntity getBusinessEntityByUserId(int id);
}
