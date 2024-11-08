package com.application.eventsbooking.models;

import jakarta.persistence.*;

@Entity
@Table(name = "eventstatus")
public class EventStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(nullable = false)
    private String statusName;

    public EventStatus(int statusId) {
        this.id = statusId;
    }
}
