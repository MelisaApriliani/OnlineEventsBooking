package com.application.eventsbooking.models;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BusinessEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected String name;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    protected User user;
}
