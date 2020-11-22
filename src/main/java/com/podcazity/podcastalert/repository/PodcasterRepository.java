package com.podcazity.podcastalert.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.podcazity.podcastalert.model.Podcaster;

public interface PodcasterRepository extends JpaRepository<Podcaster, Integer> {
    List<Podcaster> findAll();
}
