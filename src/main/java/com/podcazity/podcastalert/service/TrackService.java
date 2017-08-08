package com.podcazity.podcastalert.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.podcazity.podcastalert.model.Track;

public interface TrackService {
	Track save(Track track);
	void delete(Track track);
	Page<Track> listAllByPage(Pageable pageable);
}
