package com.application.eventsbooking.Mapper;

import com.application.eventsbooking.dto.BusinessEntityDetailsDTO;
import com.application.eventsbooking.models.Vendor;
import org.springframework.stereotype.Component;

@Component
public class VendorMapper {

    public BusinessEntityDetailsDTO toDTO(Vendor vendor) {
        BusinessEntityDetailsDTO businessEntityDetailsDTO = new BusinessEntityDetailsDTO();
        businessEntityDetailsDTO.setVendorId(vendor.getId());
        businessEntityDetailsDTO.setVendorName(vendor.getName());
        return businessEntityDetailsDTO;
    }
}