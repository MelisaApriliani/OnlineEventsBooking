package com.application.eventsbooking.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "event_status")
@Getter
@Setter
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
