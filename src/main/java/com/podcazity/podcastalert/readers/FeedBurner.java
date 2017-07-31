package com.podcazity.podcastalert.readers;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.podcazity.podcastalert.model.Track;

public class FeedBurner extends Reader {
	
	private List<Track> trackList;
    private Track track;
    
    boolean bLength = false;
    boolean bTimestamp = false;
    boolean bSize = false;
    boolean bTitle = false;
    boolean bTrackNum = false;
    boolean bFormat = false;
    boolean bLocation = false;

	@Override
	public List<Track> getTrackList() {
		return trackList;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("item")){
            track = new Track();
            trackList = new ArrayList<Track>();
        }
        else if(qName.equalsIgnoreCase("itunes:duration")){
            bLength = true;
        }
        else if(qName.equalsIgnoreCase("feedburner:origEnclosureLink")){
            bLocation = true;
        }
        else if(qName.equalsIgnoreCase("title") && track != null){
            bTitle = true;
        }
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException{
		if(qName.equalsIgnoreCase("item")){
            trackList.add(track);
        }
		
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException{
		if(bLength){
			System.out.println(new String(ch, start, length));
//            track.setTrackDuration(Integer.parseInt(new String(ch, start, length)));
            bLength = false;
        }
        else if(bTitle){
            track.setTrackTitle((new String(ch, start, length).replaceAll("\\W", "")));
            bTitle = false;
        }
        else if(bLocation){
            track.setTrackLocation(new String(ch, start, length));
            bLocation = false;
        }		
	}
	
	
}
