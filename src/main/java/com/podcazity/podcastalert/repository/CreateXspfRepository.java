package com.podcazity.podcastalert.repository;

import java.util.List;

import com.podcazity.podcastalert.model.Track;

public interface CreateXspfRepository {
    List<Track> getLastetTracks();
    void buildFile();
}
