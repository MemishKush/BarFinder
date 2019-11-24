package com.project.barfinder.repository;

import com.project.barfinder.domain.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event,String> {
    Optional<Event> findByStartTime(String startTime);
    Event findByTitle(String title);
    List<Event> findByStartTime(LocalDateTime startTime) ;
}
