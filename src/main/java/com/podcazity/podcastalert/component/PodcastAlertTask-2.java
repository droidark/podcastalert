package com.podcazity.podcastalert.component;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.podcazity.podcastalert.model.Podcast;
import com.podcazity.podcastalert.repository.CreateXspfRepository;
import com.podcazity.podcastalert.repository.DownloadFeedRepository;
import com.podcazity.podcastalert.repository.FacebookRepository;
import com.podcazity.podcastalert.repository.PodcastRepository;
import com.podcazity.podcastalert.repository.ReadFeedRepository;
import com.podcazity.podcastalert.repository.TwitterRepository;

@Component
public class PodcastAlertTask {
	
	@Resource
	private PodcastRepository podcastRepository;
	
	@Resource
	private DownloadFeedRepository downloadFeedRepository;
	
	@Resource
	private ReadFeedRepository readFeedRepository;
	
	@Resource 
	private TwitterRepository twitterRepository;
	
	@Resource
	private FacebookRepository facebookRepository;
	
	@Resource CreateXspfRepository createXspfRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(PodcastAlertTask.class);
	
	@Scheduled(fixedRate = 300000)
	public void runTask() {
		Date lastAct = new Date();
		logger.info("Getting all podcasts");
		for(Podcast p : podcastRepository.findAll()){
			logger.info("Downloading " + p.getPodcastName() +  " feed");
			downloadFeedRepository.downloadFile(p.getPodcastFeed(),
					p.getPodcastXmlFileName());
			logger.info("Reading files");
			readFeedRepository.LoadHandler(p);
			p.setTracks(readFeedRepository.createTracks());
			logger.info("New tracks for " + p.getPodcastName() + " -> " + p.getTracks().size());
			twitterRepository.sendTweet(p);
			facebookRepository.publishLink(p);
			if(!p.getTracks().isEmpty()) {
				logger.info("Updating date");
				p.setPodcastLastAct(lastAct);
				logger.info("Saving new tracks into database");
				podcastRepository.save(p);
			}
		}
		logger.info("Closing #PodcastAlert proccess\n");
//		createXspfRepository.buildFile();
//		//uploadService.uploadFile();
		/*
			
		*/
	}
}
