package com.podcazity.podcastalert.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.podcazity.podcastalert.model.Podcast;

public interface PodcastRepository extends CrudRepository<Podcast, Integer>{
	List<Podcast> findAll();
}
