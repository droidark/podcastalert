package com.podcazity.podcastalert.repository;

import com.podcazity.podcastalert.model.Podcast;

public interface TwitterRepository {
    void sendTweet(Podcast podcast);
}
