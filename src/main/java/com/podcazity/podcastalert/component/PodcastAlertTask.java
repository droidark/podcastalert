package com.podcazity.podcastalert.component;

import java.util.Date;

import javax.annotation.Resource;

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
	
	@Scheduled(fixedRate = 300000)
	public void runTask() {
		Date lastAct = new Date();
		for(Podcast p : podcastRepository.findAll()){
			downloadFeedRepository.downloadFile(p.getPodcastFeed(),
					p.getPodcastXmlFileName());
			readFeedRepository.LoadHandler(p);
			p.setTracks(readFeedRepository.createTracks());
			twitterRepository.sendTweet(p);
			facebookRepository.publishLink(p);
			if(!p.getTracks().isEmpty()) {
				p.setPodcastLastAct(lastAct);
				podcastRepository.save(p);
			}
		}
//		createXspfRepository.buildFile();
//		//uploadService.uploadFile();
	}
}
