package com.podcazity.podcastalert.service;

import com.podcazity.podcastalert.model.Podcast;

public interface TwitterService {
	void sendTweet(Podcast podcast);
}
