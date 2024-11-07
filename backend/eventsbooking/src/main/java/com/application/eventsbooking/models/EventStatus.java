package com.application.eventsbooking.models;

import jakarta.persistence.*;

@Entity
@Table(name = "eventstatus")
public class EventStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusId;


    @Column(nullable = false)
    private String statusName;
}
