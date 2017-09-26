package com.podcazity.podcastalert.repository.impl;

import java.io.File;
import java.util.Set;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.stereotype.Repository;

import com.podcazity.podcastalert.model.Podcast;
import com.podcazity.podcastalert.model.Track;
import com.podcazity.podcastalert.readers.FeedBurner;
import com.podcazity.podcastalert.readers.ITunes;
import com.podcazity.podcastalert.readers.Reader;
import com.podcazity.podcastalert.repository.ReadFeedRepository;

@Repository("readFeedRepository")
public class ReadFeedRepositoryImpl implements ReadFeedRepository{

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
