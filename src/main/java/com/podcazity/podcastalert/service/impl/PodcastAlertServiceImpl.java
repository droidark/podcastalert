package com.podcazity.podcastalert.service.impl;

import com.podcazity.podcastalert.repository.PodcastRepository;
import com.podcazity.podcastalert.service.DownloadFeedService;
import com.podcazity.podcastalert.service.PodcastAlertService;
import com.podcazity.podcastalert.service.ReadFeedService;
import com.podcazity.podcastalert.service.SocialNetworkService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@Service
public class PodcastAlertServiceImpl implements PodcastAlertService {

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
        log.info("Getting all podcasts");
        podcastRepository.findByPodcastActive(true).forEach(p -> {
            log.info("Downloading " + p.getPodcastName() + " feed");
            downloadFeedService.downloadFile(p.getPodcastFeed(), p.getPodcastXmlFileName());
            log.info("Reading files");
            readFeedService.LoadHandler(p);
            p.setTracks(readFeedService.createTracks());
            if (p.getTracks() != null) {
                log.info("New tracks for " + p.getPodcastName() + " -> " + p.getTracks().size());
                //twitterService.publishLink(p);
                //facebookService.publishLink(p);
                if(!p.getTracks().isEmpty()) {
                    log.info("Updating date");
                    p.setPodcastLastAct(lastAct);
                    log.info("Saving new tracks into database");
                    podcastRepository.save(p);
                }
            }
        });
        log.info("Closing #PodcastAlert process\n");
    }
}
