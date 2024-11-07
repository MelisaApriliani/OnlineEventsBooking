package com.application.eventsbooking.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "company")
public class Company extends BusinessEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String name;
//
//    @OneToOne
//    @JoinColumn(name = "user_id", nullable = false, unique = true)
//    private User user;

    @Column(nullable = false)
    private String industry;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events;

    public Company() {}

    public Company(String name, User user) {
        this.name = name;
        this.user = user;
    }
}
