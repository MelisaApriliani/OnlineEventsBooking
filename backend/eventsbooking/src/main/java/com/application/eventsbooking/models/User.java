package com.application.eventsbooking.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "account")
public class User  {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Getter
    @NotNull(message = "Username cannot be null")
    @NotEmpty(message = "Username cannot be empty")
    @Size(min = 5, max = 50, message = "Username must be between 5 and 50 characters")
    @Email(message = "Username must be a valid email address")  // Validates the email format
    @Column(nullable = false, unique = true)
    private String username;

    @Setter
    @Getter
    @NotNull(message = "Password cannot be null")
    @Size(min = 6, max = 255, message = "Password must be at least 6 characters long")
    @Column(nullable = false)
    private String password;

    @Getter
    @NotNull(message = "Role cannot be null")
    @Size(min = 6,max = 50, message = "Password must be at least 6 characters long")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

}




