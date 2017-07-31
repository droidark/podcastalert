package com.podcazity.podcastalert.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.podcazity.podcastalert.model.Podcaster;

public interface PodcasterRepository extends CrudRepository<Podcaster, Integer>{
	List<Podcaster> findAll();
}
