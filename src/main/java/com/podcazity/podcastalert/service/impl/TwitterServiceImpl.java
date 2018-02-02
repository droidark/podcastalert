package com.podcazity.podcastalert.service.impl;

//import java.io.File;

import org.springframework.stereotype.Service;

import com.podcazity.podcastalert.model.Podcast;
import com.podcazity.podcastalert.service.TwitterService;

//import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

@Service("twitterService")
public class TwitterServiceImpl implements TwitterService{

	@Override
	public void sendTweet(Podcast podcast) {
		try {
			TwitterFactory factory = new TwitterFactory();
			Twitter twitter = factory.getInstance();
//			for(int i = podcast.getTracks().size() - 1; i >= 0; i--) {
//				StatusUpdate status = new StatusUpdate("#PodcastAlert! " + 
//						podcast.getTracks().get(i).getTrackTitle() + " " + 
//						podcast.getTracks().get(i).getTrackLocation() + " " + 
//						podcast.getPodcastTwitter() + " ");
////				status.setMedia(new File(podcast.getPodcastArtWork()));
//				twitter.updateStatus(status);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
