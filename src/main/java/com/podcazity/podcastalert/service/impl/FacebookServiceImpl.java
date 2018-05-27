package com.podcazity.podcastalert.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.podcazity.podcastalert.model.Podcast;
import com.podcazity.podcastalert.service.FacebookService;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;

@Service("facebookService")
@PropertySource(value = {"classpath:restfb.properties"})
public class FacebookServiceImpl implements FacebookService{
	
	@Value("${restfb.pageAccessToken}")
	private String pageAccessToken;
	
	@Value("${restfb.pageId}")
	private String pageId;
	
	private FacebookClient fbClient;

	@Override
	public void publishLink(Podcast podcast) {
		try {
			fbClient = new DefaultFacebookClient(pageAccessToken, Version.VERSION_3_0);
			
//			for(int i = podcast.getTracks().size() - 1; i >= 0; i--) {
//				fbClient.publish(pageId + "/feed", FacebookType.class, 
//						Parameter.with(
//								"link", 
//								podcast.getTracks().get(i).getTrackLocation()),
//						Parameter.with(
//								"message", 
//								"#PodcastAlert " + 
//								podcast.getTracks().get(i).getTrackTitle() + 
//								" vía " + podcast.getPodcastFacebook()));
//			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
