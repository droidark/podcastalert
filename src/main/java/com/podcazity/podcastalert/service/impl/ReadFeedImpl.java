package com.podcazity.podcastalert.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.stereotype.Service;

import com.podcazity.podcastalert.model.Track;
import com.podcazity.podcastalert.readers.FeedBurner;
import com.podcazity.podcastalert.readers.Reader;
import com.podcazity.podcastalert.service.ReadFeed;

@Service("readFeed")
public class ReadFeedImpl implements ReadFeed{

	private Reader handler;
	private SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	
	@Override
	public void LoadHandler(String readerType) {
		if(readerType.equals("FeedBurner")){
			handler = new FeedBurner();
		} else if(readerType.equals("Archive")) {
			
		} else if(readerType.equals("ITunes")) {
			
		}
	}

	@Override
	public Track createTrack() {
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			saxParser.parse(new File("C:\\virux\\los-inmamables.xml"), handler);
			List<Track> trackList= handler.getTrackList();
			for(Track t : trackList){
				System.out.println(t.getTrackLocation());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
