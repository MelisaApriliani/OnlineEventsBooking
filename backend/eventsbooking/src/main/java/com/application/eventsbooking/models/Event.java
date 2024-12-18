package com.application.eventsbooking.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "event")
public class Event {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    @NotNull(message = "Event name cannot be null")
    @Size(min = 3, max = 50, message = "Event name must be at least 3 characters long")
    @Column(name = "event_name", nullable = false)
    private String eventName;

    @Getter
    @Setter
    @Column(name = "description")
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
    private List<EventDate> eventDates = new ArrayList<>();;

    @Getter
    @Setter
    @Column(name = "date_created", nullable = false)
    private LocalDateTime dateCreated;

    @Getter
    @Setter
    @Column
    private String remarks;

    //Helper methods for table relations
    public void addEventDate(EventDate eventDate) {
        eventDates.add(eventDate);
        eventDate.setEvent(this);
    }

    public void removeEventDate(EventDate eventDate) {
        eventDates.remove(eventDate);
        eventDate.setEvent(null);
    }
}
