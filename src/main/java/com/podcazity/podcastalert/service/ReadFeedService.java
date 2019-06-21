package com.podcazity.podcastalert.service;

import com.podcazity.podcastalert.model.Podcast;
import com.podcazity.podcastalert.model.Track;

import java.util.Set;

public interface ReadFeedService {
    void LoadHandler(Podcast podcast);
    Set<Track> createTracks();
}
