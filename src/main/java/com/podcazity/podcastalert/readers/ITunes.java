package com.podcazity.podcastalert.readers;

import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.podcazity.podcastalert.model.Track;

public class ITunes extends Reader {

	@Override
	public List<Track> getTrackList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		
	}

}
