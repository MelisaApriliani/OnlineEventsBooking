package com.application.eventsbooking.repositories;

import com.application.eventsbooking.models.EventDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventDateRepository extends JpaRepository<EventDate, Integer> {
    List<EventDate> findByEventId(int eventId);
}
