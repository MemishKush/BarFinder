package com.project.barfinder.repository;

import com.project.barfinder.domain.entities.Bar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BarRepository extends JpaRepository <Bar,String> {
    Optional<Bar> findByName(String name);
}
