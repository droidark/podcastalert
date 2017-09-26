package com.podcazity.podcastalert.service;

import java.util.List;

import com.podcazity.podcastalert.model.Track;

public interface CreateXspf {
	List<Track> getLastetTracks();
	void buildFile();
}
