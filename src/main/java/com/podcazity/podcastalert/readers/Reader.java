package com.podcazity.podcastalert.readers;

import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.podcazity.podcastalert.model.Track;

public abstract class Reader extends DefaultHandler {
	public abstract List<Track> getTrackList();
	public abstract void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException;
	public abstract void endElement(String uri, String localName, String qName) throws SAXException;
	public abstract void characters(char ch[], int start, int length) throws SAXException;
}
