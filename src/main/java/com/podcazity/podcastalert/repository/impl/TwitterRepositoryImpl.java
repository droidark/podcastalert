package com.podcazity.podcastalert.repository.impl;

import java.io.File;

import org.springframework.stereotype.Repository;

//import java.io.File;

import com.podcazity.podcastalert.model.Podcast;
import com.podcazity.podcastalert.model.Track;
import com.podcazity.podcastalert.repository.TwitterRepository;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

@Repository("twitterRepository")
public class TwitterRepositoryImpl implements TwitterRepository{

	@Override
	public void sendTweet(Podcast podcast) {
		try {
			TwitterFactory factory = new TwitterFactory();
			Twitter twitter = factory.getInstance();
			
			for(Track t : podcast.getTracks()) {
				StatusUpdate status = new StatusUpdate("#PodcastAlert " + 
				t.getTrackTitle() + " " + 
				t.getTrackLocation() + " vía " + 
				podcast.getPodcastTwitter() + " ");
				status.setMedia(new File(podcast.getPodcastArtWork()));
				twitter.updateStatus(status);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
