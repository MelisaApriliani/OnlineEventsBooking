package com.application.eventsbooking.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public abstract class BusinessEntity {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Setter
    @Getter
    @Column(nullable = false)
    protected String name;

    @Setter
    @Getter
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    protected User user;
}
