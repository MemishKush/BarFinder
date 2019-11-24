package com.project.barfinder.repository;

import com.project.barfinder.domain.entities.Bar;
import com.project.barfinder.domain.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ReviewRepository extends JpaRepository<Review,String> {
    Optional<Review> findByBar(Bar bar);
}
