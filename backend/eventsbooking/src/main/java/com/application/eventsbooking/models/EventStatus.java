package com.application.eventsbooking.models;

import jakarta.persistence.*;

@Entity
@Table(name = "event_status")
public class EventStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusId;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(nullable = false)
    private String statusName; // e.g., Pending, Approved, Rejected

    @Column
    private String remarks;

}
