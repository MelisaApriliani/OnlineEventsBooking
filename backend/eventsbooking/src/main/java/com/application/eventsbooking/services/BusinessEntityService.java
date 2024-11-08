package com.application.eventsbooking.services;

import com.application.eventsbooking.dto.BusinessEntityDetailsDTO;
import com.application.eventsbooking.models.Role;

public interface BusinessEntityService {

    Role getRole();

    public BusinessEntityDetailsDTO getBusinessEntityByUserId(int id);
}
