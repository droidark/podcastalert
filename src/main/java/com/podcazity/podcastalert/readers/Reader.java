package com.podcazity.podcastalert.readers;

import java.util.HashSet;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.podcazity.podcastalert.model.Podcast;
import com.podcazity.podcastalert.model.Track;

public abstract class Reader extends DefaultHandler {
	
	boolean identifier;
    boolean title;
    boolean annotation;
    boolean image;
    boolean trackNum;
    boolean date;
    boolean link;
    
    Set<Track> trackList = new HashSet<Track>();
    Track track;
	
	Podcast podcast;
	
	public Reader(Podcast podcast) {
		this.podcast = podcast;
	}
	
	public Set<Track> getTrackList() {
		return trackList;
	}
	
	public abstract void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException;
	
	public void endElement(String uri, String localName, String qName) 
			throws SAXException {
		if(qName.equalsIgnoreCase("item") 
				&& track.getTrackDate().after(podcast.getPodcastLastAct())) {
			track.setPodcast(podcast);
            trackList.add(track);
        }		
	}
	
	public abstract void characters(char ch[], int start, int length) throws SAXException;
}
