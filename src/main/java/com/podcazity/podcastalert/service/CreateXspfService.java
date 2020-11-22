package com.podcazity.podcastalert.service;

import com.podcazity.podcastalert.model.Track;

import java.util.List;

public interface CreateXspfService {
    List<Track> getLatestTracks();
    void buildFile();
}
