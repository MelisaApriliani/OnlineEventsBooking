package com.application.eventsbooking.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "location")
public class Location {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    @NotNull(message = "Location name cannot be null")
    @Size(min = 5, max = 50, message = "Location name must be at least 5 characters long")
    @Column(nullable = false)
    private String name;

    @Getter
    @Setter
    @Size(max = 10, message = "Postalcode must be maximum 10 characters long")
    @Column(name = "postal_code")
    private String postalCode;

    @Getter
    @Setter
    @NotNull(message = "Address cannot be null")
    @Size(min = 10, max = 100, message = "Location name must be at least 10 characters long")
    @Column(nullable = false)
    private String address;

}
