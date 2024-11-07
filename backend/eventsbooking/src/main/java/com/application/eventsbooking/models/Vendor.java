package com.application.eventsbooking.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vendor")
public class Vendor extends BusinessEntity {

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events;

    public Vendor() {}

    public Vendor(String vendorName, User user) {
        this.name = vendorName;
        this.user = user;
    }

}
