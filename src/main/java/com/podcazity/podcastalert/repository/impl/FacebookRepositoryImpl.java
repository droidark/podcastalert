package com.podcazity.podcastalert.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import com.podcazity.podcastalert.model.Podcast;
import com.podcazity.podcastalert.model.Track;
import com.podcazity.podcastalert.repository.FacebookRepository;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;

@Repository("facebookRepository")
@PropertySource(value = {"classpath:restfb.properties"})
public class FacebookRepositoryImpl implements FacebookRepository {
	
	@Value("${restfb.pageAccessToken}")
	private String pageAccessToken;
	
	@Value("${restfb.pageId}")
	private String pageId;
	
	private static final Logger logger = LoggerFactory.getLogger(FacebookRepositoryImpl.class);
	
	private FacebookClient fbClient;

	@Override
	public void publishLink(Podcast podcast) {
		String url = "";
		try {
			fbClient = new DefaultFacebookClient(pageAccessToken, Version.VERSION_3_0);
			for(Track t : podcast.getTracks()) {
				logger.info("Sending Faceboo post: #PodcastAlert " + t.getTrackTitle() + " vía " + podcast.getPodcastFacebook());
				url = t.getTrackPage() == null ? t.getTrackLocation() : t.getTrackPage();
				fbClient.publish(pageId + "/feed", FacebookType.class, 
				Parameter.with(
						"link", 
						url),
				Parameter.with(
						"message", 
						"#PodcastAlert " + 
						t.getTrackTitle() + 
						" vía " + podcast.getPodcastFacebook()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
