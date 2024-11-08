package com.application.eventsbooking.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "company")
public class Company extends BusinessEntity {

    @Column(nullable = false)
    private String companyCode;

    @Column(nullable = false)
    private String industry;

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
