package com.podcazity.podcastalert;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.podcazity.podcastalert.model.Podcast;
import com.podcazity.podcastalert.service.DownloadFeedService;
import com.podcazity.podcastalert.service.FacebookService;
import com.podcazity.podcastalert.service.PodcastService;
import com.podcazity.podcastalert.service.ReadFeed;
import com.podcazity.podcastalert.service.TwitterService;

@SpringBootApplication
public class PodcastalertApplication implements CommandLineRunner{
	
	@Autowired
	private PodcastService podcastService;
	
	@Autowired
	private DownloadFeedService downloadFeedService;
	
	@Autowired
	private ReadFeed readFeed;
	
	@Autowired
	private TwitterService twitterService;
	
	@Autowired
	private FacebookService facebookService; 
	
	public static void main(String[] args) {
		SpringApplication.run(PodcastalertApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Date lastAct = new Date();
		for(Podcast p : podcastService.findAll()){
			downloadFeedService.downloadFile(p.getPodcastFeed(),
					p.getPodcastXmlFileName());
			readFeed.LoadHandler(p);
			p.setTracks(readFeed.createTracks());
			//twitterService.sendTweet(p);
			//facebookService.publishLink(p);
			if(!p.getTracks().isEmpty()) {
				p.setPodcastLastAct(lastAct);
				podcastService.save(p);
			}
		}
	}
}
