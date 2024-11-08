package com.application.eventsbooking.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "company")
public class Company extends BusinessEntity {

    @Size(min = 3,max = 50)
    @Column(name = "company_code", nullable = false)
    private String companyCode;

    public Company() {}

    public Company(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public Company(int companyId) {
        super();
        this.id = companyId;
    }
}
