package com.application.eventsbooking.models;

import jakarta.persistence.*;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column()
    private String postalCode;

    @Column(nullable = false)
    private String address;

}
