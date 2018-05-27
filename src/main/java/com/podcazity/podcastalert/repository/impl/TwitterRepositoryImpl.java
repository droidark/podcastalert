package com.podcazity.podcastalert.repository.impl;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.podcazity.podcastalert.model.Podcast;
import com.podcazity.podcastalert.model.Track;
import com.podcazity.podcastalert.repository.TwitterRepository;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

@Repository("twitterRepository")
public class TwitterRepositoryImpl implements TwitterRepository{
	
	private static final Logger logger = LoggerFactory.getLogger(TwitterRepositoryImpl.class);

	@Override
	public void sendTweet(Podcast podcast) {
		try {
			TwitterFactory factory = new TwitterFactory();
			Twitter twitter = factory.getInstance();
			
			for(Track t : podcast.getTracks()) {
				logger.info("Sending tweet: #PodcastAlert " + t.getTrackTitle() + " " 
			+ t.getTrackPage() + " vía " + podcast.getPodcastTwitter());
				StatusUpdate status = new StatusUpdate("#PodcastAlert " + 
				t.getTrackTitle() + " " + 
				t.getTrackPage() + " vía " + 
				podcast.getPodcastTwitter() + " ");
				// Put podcast conver in tweet
				//status.setMedia(new File(podcast.getPodcastArtWork()));
				twitter.updateStatus(status);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
