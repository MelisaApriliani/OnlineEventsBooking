package com.application.eventsbooking.repositories;

import com.application.eventsbooking.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    Event findById(int id);
    List<Event> findByCompany_Id(int id);
    List<Event> findByVendor_Id(int id);
}
