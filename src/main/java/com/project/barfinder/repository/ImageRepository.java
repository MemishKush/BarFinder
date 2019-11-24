package com.project.barfinder.repository;

import com.project.barfinder.domain.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image,String> {
    Optional<Image> findByUrl(String url);
}
