package com.application.eventsbooking.repositories;

import com.application.eventsbooking.models.Event;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    Event findById(int id);
    List<Event> findByCompany_Id(int id);
    List<Event> findByVendor_Id(int id);
    @Modifying
    @Transactional
    @Query("UPDATE Event e SET e.status.id = :statusId, e.remarks = :remarks WHERE e.id = :id")
    int updateEvent(@Param("id") Long id,
                    @Param("statusId") Long statusId,
                    @Param("remarks") String remarks);
}
