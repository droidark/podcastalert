package com.podcazity.podcastalert.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.podcazity.podcastalert.model.Track;

public interface TrackRepository extends JpaRepository<Track, Integer> {
    Track findByTrackLocation(String trackLocation);
}
