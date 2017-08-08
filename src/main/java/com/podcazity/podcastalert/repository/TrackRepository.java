package com.podcazity.podcastalert.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.podcazity.podcastalert.model.Track;

public interface TrackRepository extends PagingAndSortingRepository<Track, Integer>{
	
}
