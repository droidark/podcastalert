package com.podcazity.podcastalert.service;

import java.util.Set;

import com.podcazity.podcastalert.model.Podcast;
import com.podcazity.podcastalert.model.Track;

public interface ReadFeed {
	void LoadHandler(Podcast podcast);
	Set<Track> createTracks();
}
