package com.podcazity.podcastalert.service;

import java.util.List;

import com.podcazity.podcastalert.model.Podcaster;

public interface PodcasterService {
	Podcaster save(Podcaster podcaster);
	void delete(Podcaster podcaster);
	List<Podcaster> findAll();
}
