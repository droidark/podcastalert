package com.podcazity.podcastalert.service.impl;

import com.podcazity.podcastalert.repository.PodcastRepository;
import com.podcazity.podcastalert.service.DownloadFeedService;
import com.podcazity.podcastalert.service.PodcastAlertService;
import com.podcazity.podcastalert.service.ReadFeedService;
import com.podcazity.podcastalert.service.SocialNetworkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class PodcastAlertServiceImpl implements PodcastAlertService {

    private static final Logger logger = LoggerFactory.getLogger(PodcastAlertServiceImpl.class);

    @Resource
    private PodcastRepository podcastRepository;

    private DownloadFeedService downloadFeedService;
    private ReadFeedService readFeedService;
    private SocialNetworkService twitterService;
    private SocialNetworkService facebookService;

    public PodcastAlertServiceImpl(DownloadFileServiceImpl downloadFeedService,
                                   ReadFeedServiceImpl readFeedService,
                                   TwitterServiceImpl twitterService,
                                   FacebookServiceImpl facebookService) {
        this.downloadFeedService = downloadFeedService;
        this.readFeedService = readFeedService;
        this.twitterService = twitterService;
        this.facebookService = facebookService;
    }

    @Override
    @Scheduled(fixedRate = 300000)
    public void podcastAlertTask() {
        Date lastAct = new Date();
        logger.info("Getting all podcasts");
        podcastRepository.findByPodcastActive(true).forEach(p -> {
            logger.info("Downloading " + p.getPodcastName() + " feed");
            downloadFeedService.downloadFile(p.getPodcastFeed(), p.getPodcastXmlFileName());
            logger.info("Reading files");
            readFeedService.LoadHandler(p);
            p.setTracks(readFeedService.createTracks());
            logger.info("New tracks for " + p.getPodcastName() + " -> " + p.getTracks().size());
//            twitterService.publishLink(p);
//            facebookService.publishLink(p);
            if(!p.getTracks().isEmpty()) {
                logger.info("Updating date");
                p.setPodcastLastAct(lastAct);
                logger.info("Saving new tracks into database");
                podcastRepository.save(p);
            }
        });
        logger.info("Closing #PodcastAlert process\n");
    }
}
