package com.application.eventsbooking.services;

import com.application.eventsbooking.Mapper.VendorMapper;
import com.application.eventsbooking.dto.BusinessEntityDetailsDTO;
import com.application.eventsbooking.models.Role;
import com.application.eventsbooking.models.Vendor;
import com.application.eventsbooking.repositories.VendorRepository;
import org.hibernate.boot.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements BusinessEntityService, VendorService {

    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;

    @Autowired
    public VendorServiceImpl(VendorRepository vendorRepository, VendorMapper vendorMapper) {
        this.vendorRepository = vendorRepository;
        this.vendorMapper = vendorMapper;
    }


    @Override
    public Role getRole() {
        return Role.ADMIN;
    }

    @Override
    public BusinessEntityDetailsDTO getBusinessEntityByUserId(int id) {
        Vendor vendor = vendorRepository.findByUserId(id);
        if (vendor == null) {
            throw new RuntimeException("Vendor with id is not found.");
        }
        try {
            return vendorMapper.toDTO(vendor);
        }catch (Exception e){
            throw new IllegalStateException("Error mapping Vendor to DTO", e);
        }

    }

    @Override
    public List<BusinessEntityDetailsDTO> getAllVendors() {

        List<Vendor> vendors = vendorRepository.findAll();

        if (vendors.isEmpty()) {
            return Collections.emptyList();
        }
        return vendors.stream()
                .map(vendor -> {
                    try {
                        return vendorMapper.toDTO(vendor);
                    } catch (Exception e) {
                        // handle mapping exception
                        throw new IllegalStateException("Error mapping Vendor to DTO", e);
                    }
                })
                .collect(Collectors.toList());
    }
}
