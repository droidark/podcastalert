package com.podcazity.podcastalert.repository;

import com.podcazity.podcastalert.model.Podcast;

public interface FacebookRepository {
    void publishLink(Podcast podcast);
}
