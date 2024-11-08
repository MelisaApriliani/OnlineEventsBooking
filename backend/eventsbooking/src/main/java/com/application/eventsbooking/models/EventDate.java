package com.application.eventsbooking.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "event_date")
public class EventDate {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Getter
    @Setter
    @Column(nullable = false)
    private LocalDateTime date;

    // Constructors, Getters, Setters, etc.
}
