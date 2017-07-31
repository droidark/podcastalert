package com.podcazity.podcastalert.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.podcazity.podcastalert.model.Track;

public interface TrackRepository extends CrudRepository<Track, Integer>{
	List<Track> findAll();
}
