package com.podcazity.podcastalert.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.podcazity.podcastalert.model.Podcast;

public interface PodcastRepository extends JpaRepository<Podcast, Integer> {
    List<Podcast> findAll();
    List<Podcast> findByPodcastActive(boolean active);
}
