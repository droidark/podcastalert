package com.podcazity.podcastalert.service;

import java.util.List;

import com.podcazity.podcastalert.model.Podcast;

public interface PodcastService {
	Podcast save(Podcast podcast);
	void delete(Podcast podcast);
	List<Podcast> findAll();
}
