package com.podcazity.podcastalert.service;

import java.util.List;

import com.podcazity.podcastalert.model.Podcast;
import com.podcazity.podcastalert.model.Track;

public interface ReadFeed {
	void LoadHandler(Podcast podcast);
	List<Track> createTracks();
}
