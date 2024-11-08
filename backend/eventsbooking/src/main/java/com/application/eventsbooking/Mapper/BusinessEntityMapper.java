package com.application.eventsbooking.Mapper;

import com.application.eventsbooking.dto.BusinessEntityDetailsDTO;
import com.application.eventsbooking.models.BusinessEntity;
import com.application.eventsbooking.models.Vendor;
import org.springframework.stereotype.Component;

@Component
public class BusinessEntityMapper {

    public BusinessEntityDetailsDTO toDTO(BusinessEntity entity) {
        BusinessEntityDetailsDTO businessEntityDetailsDTO = new BusinessEntityDetailsDTO();
        businessEntityDetailsDTO.setVendorId(entity.getId());
        businessEntityDetailsDTO.setBusinessEntityName(entity.getName());
        return businessEntityDetailsDTO;
    }
}