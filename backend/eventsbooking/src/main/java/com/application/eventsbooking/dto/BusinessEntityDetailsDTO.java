package com.application.eventsbooking.dto;

import lombok.Getter;
import lombok.Setter;

public class BusinessEntityDetailsDTO{

    @Setter
    @Getter
    private int businessId;

    @Setter
    @Getter
    private String businessEntityName;

    @Setter
    @Getter
    private String role;

}
