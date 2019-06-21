package com.podcazity.podcastalert.service.impl;

import com.podcazity.podcastalert.model.Podcast;
import com.podcazity.podcastalert.model.Track;
import com.podcazity.podcastalert.readers.FeedBurner;
import com.podcazity.podcastalert.readers.ITunes;
import com.podcazity.podcastalert.readers.Reader;
import com.podcazity.podcastalert.service.ReadFeedService;
import org.springframework.stereotype.Service;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.Set;

@Service
public class ReadFeedServiceImpl implements ReadFeedService {
    private Reader handler;
    private Podcast podcast;
    private SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

    @Override
    public void LoadHandler(Podcast podcast) {
        this.podcast = podcast;
        if(podcast.getPodcastReader().equals("FeedBurner")){
            handler = new FeedBurner(podcast);
        } else if(podcast.getPodcastReader().equals("ITunes")) {
            handler = new ITunes(podcast);
        }
    }

    @Override
    public Set<Track> createTracks() {
        Set<Track> trackList = null;
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(new File("xml\\" + podcast.getPodcastXmlFileName()), handler);
            trackList = handler.getTrackList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trackList;
    }
}
