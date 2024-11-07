package com.application.eventsbooking.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "proposed_dates")
public class ProposedDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(nullable = false)
    private LocalDateTime proposedDate;

    // Constructors, Getters, Setters, etc.
}
