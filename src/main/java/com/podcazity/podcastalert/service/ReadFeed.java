package com.podcazity.podcastalert.service;

import com.podcazity.podcastalert.model.Track;

public interface ReadFeed {
	void LoadHandler(String readerType);
	Track createTrack();
}
