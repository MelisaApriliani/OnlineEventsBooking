package com.application.eventsbooking.repositories;

import com.application.eventsbooking.models.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventStatusRepository extends JpaRepository<EventStatus, Integer> {
    EventStatus findById(int id);
}
