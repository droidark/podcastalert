package com.podcazity.podcastalert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.podcazity.podcastalert.model.Podcast;
import com.podcazity.podcastalert.service.DownloadFeedService;
import com.podcazity.podcastalert.service.PodcastService;
import com.podcazity.podcastalert.service.ReadFeed;

@SpringBootApplication
public class PodcastalertApplication implements CommandLineRunner{
	
	@Autowired
	private PodcastService podcastService;
	
	@Autowired
	private DownloadFeedService downloadFeedService;
	
	@Autowired
	private ReadFeed readFeed;

	public static void main(String[] args) {
		SpringApplication.run(PodcastalertApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		for(Podcast p : podcastService.findAll()){
			downloadFeedService.downloadFile(p.getPodcastFeed(), p.getPodcastXmlFileName());
			readFeed.LoadHandler(p.getPodcastReader());
			readFeed.createTrack();
		}
	}
	

}
