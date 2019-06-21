package com.podcazity.podcastalert.service.impl;

import com.podcazity.podcastalert.model.Podcast;
import com.podcazity.podcastalert.model.Track;
import com.podcazity.podcastalert.service.SocialNetworkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

@Service("twitterService")
public class TwitterServiceImpl implements SocialNetworkService {

    private static final Logger logger = LoggerFactory.getLogger(TwitterServiceImpl.class);

    @Override
    public void publishLink(Podcast podcast) {
        String url, tweet, network;
        try {
            TwitterFactory factory = new TwitterFactory();
            Twitter twitter = factory.getInstance();
            for(Track t : podcast.getTracks()) {
                url = t.getTrackPage() == null ? t.getTrackLocation() : t.getTrackPage();
                network = podcast.getNetwork() == null ? "" : " " + podcast.getNetwork().getNetworkTwitter();
                tweet = "#PodcastAlert " + t.getTrackTitle() + " " + url + " vía " + podcast.getPodcastTwitter() + network;
                logger.info("Sending tweet: " + tweet);
                StatusUpdate status = new StatusUpdate(tweet);
                // Put podcast cover in tweet
                //status.setMedia(new File(podcast.getPodcastArtWork()));
                twitter.updateStatus(status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
