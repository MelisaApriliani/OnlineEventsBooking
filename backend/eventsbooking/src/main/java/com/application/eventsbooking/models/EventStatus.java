package com.application.eventsbooking.models;

import jakarta.persistence.*;

@Entity
@Table(name = "event_status")
public class EventStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "status_name",nullable = false)
    private String statusName;

    public EventStatus(int statusId) {
        this.id = statusId;
    }

    public EventStatus() {

    }
}
