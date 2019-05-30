package com.podcazity.podcastalert.repository;

import java.util.Set;

import com.podcazity.podcastalert.model.Podcast;
import com.podcazity.podcastalert.model.Track;

public interface ReadFeedRepository {
    void LoadHandler(Podcast podcast);
    Set<Track> createTracks();
}
