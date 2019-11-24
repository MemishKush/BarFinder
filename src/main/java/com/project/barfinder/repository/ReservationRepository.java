package com.project.barfinder.repository;

import com.project.barfinder.domain.entities.Bar;
import com.project.barfinder.domain.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,String> {
    Optional<Reservation> findByBar(Bar bar);
}
