package com.project.barfinder.repository;

import com.project.barfinder.domain.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event,String> {
    Optional<Event> findByStartTime(String startTime);
}
