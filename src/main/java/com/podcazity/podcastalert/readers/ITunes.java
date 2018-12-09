package com.podcazity.podcastalert.readers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.podcazity.podcastalert.model.Podcast;
import com.podcazity.podcastalert.model.Track;

public class ITunes extends Reader {
	
	public ITunes(Podcast podcast) {
		super(podcast);
	}

	@Override
	public void startElement(String uri, String localName, String qName, 
			Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("item")){
			track = new Track();
        } else if(qName.equals("enclosure")){
        	track.setTrackLocation(attributes.getValue("url"));
        	track.setTrackDuration(Integer.parseInt(attributes.getValue("length")));
        } else if(qName.equals("pubDate") && track != null) {
        	date = true;
        } else if(qName.equals("link") && track != null) {
        	link = true;
        } else if(qName.equalsIgnoreCase("atom:link") && track != null){
    		track.setTrackPage(attributes.getValue("url"));
			link = false;
        } else if(qName.equalsIgnoreCase("title") && track != null){
            title = true;
        }
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(title){
            track.setTrackTitle((new String(ch, start, length).replace("&quot;", "\"")));
            title = false;
        } else if(link) {
        	track.setTrackPage((new String(ch, start, length)));
        	link = false;
        } else if(date) {
        	try {
        		DateFormat formatter = 
        				new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", 
        						Locale.ENGLISH);
				Date pubDate = formatter.parse(new String(ch, start, length));
				track.setTrackDate(pubDate);
				date = false;
			} catch (ParseException e) {
				e.printStackTrace();
			}
        }
	}

}
