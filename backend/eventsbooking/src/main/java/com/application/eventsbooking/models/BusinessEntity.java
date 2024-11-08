package com.application.eventsbooking.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull(message = "Business entity name cannot be null")
    @Size(min = 3,max = 50, message = "Business entity name must be at least 3 characters long")
    protected String name;

    @Setter
    @Getter
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    protected User user;
}
