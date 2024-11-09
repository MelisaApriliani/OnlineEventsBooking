package com.application.eventsbooking.Mapper;

import com.application.eventsbooking.dto.BusinessEntityDetailsDTO;
import com.application.eventsbooking.models.BusinessEntity;
import org.springframework.stereotype.Component;

@Component
public class BusinessEntityMapper {

    public BusinessEntityDetailsDTO toDTO(BusinessEntity entity) {
        BusinessEntityDetailsDTO businessEntityDetailsDTO = new BusinessEntityDetailsDTO();
        businessEntityDetailsDTO.setBusinessId(entity.getId());
        businessEntityDetailsDTO.setBusinessEntityName(entity.getName());
        return businessEntityDetailsDTO;
    }
}