package com.podcazity.podcastalert.service.impl;

import com.podcazity.podcastalert.model.Podcast;
import com.podcazity.podcastalert.model.Track;
import com.podcazity.podcastalert.service.SocialNetworkService;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("facebookService")
public class FacebookServiceImpl implements SocialNetworkService {

    @Value("${restfb.pageAccessToken}")
    private String pageAccessToken;

    @Value("${restfb.pageId}")
    private String pageId;

    private static final Logger logger = LoggerFactory.getLogger(FacebookServiceImpl.class);

    private FacebookClient fbClient;

    @Override
    public void publishLink(Podcast podcast) {
        String url, network;
        try {
            fbClient = new DefaultFacebookClient(pageAccessToken, Version.VERSION_8_0);
            for(Track t : podcast.getTracks()) {
                url = t.getTrackPage() == null ? t.getTrackLocation() : t.getTrackPage();
                network = podcast.getNetwork() == null ? "" : podcast.getNetwork().getNetworkFacebook();
                logger.info("Sending Facebook post: #PodcastAlert " + t.getTrackTitle() + " " + url + " vía "
                        + podcast.getPodcastFacebook() + " " + network);
                fbClient.publish(pageId + "/feed", FacebookType.class,
                        Parameter.with(
                                "link",
                                url),
                        Parameter.with(
                                "message",
                                "#PodcastAlert " +
                                        t.getTrackTitle() +
                                        " vía " + podcast.getPodcastFacebook() + " " + network));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
