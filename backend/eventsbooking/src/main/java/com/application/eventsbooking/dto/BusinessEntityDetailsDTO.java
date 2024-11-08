package com.application.eventsbooking.dto;

import lombok.Getter;
import lombok.Setter;

public class BusinessEntityDetailsDTO extends DataDTO {

    @Setter
    @Getter
    private int vendorId;

    @Setter
    @Getter
    private String vendorName;

}
