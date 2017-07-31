package com.podcazity.podcastalert.service;

import java.util.List;

import com.podcazity.podcastalert.model.Track;

public interface TrackService {
	Track save(Track track);
	void delete(Track track);
	List<Track> findAll();
}
