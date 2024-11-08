package com.application.eventsbooking.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "events")
public class Event {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String eventName;

    @Getter
    @Setter
    @Column(nullable = false)
    private String description;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "event_status_id", nullable = false)
    private EventStatus status;

    @Getter
    @Setter
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EventDate> eventDates;

    @Getter
    @Setter
    @Column(nullable = false)
    private LocalDateTime dateCreated;

    @Getter
    @Setter
    @Column
    private String remarks;

    // Constructors, Getters, Setters, etc.
}
