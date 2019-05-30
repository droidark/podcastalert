package com.podcazity.podcastalert.repository.impl;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.podcazity.podcastalert.model.Track;
import com.podcazity.podcastalert.repository.CreateXspfRepository;
import com.podcazity.podcastalert.repository.TrackRepository;

@Repository("createXspfRepository")
public class CreateXspfImpl implements CreateXspfRepository{

    @Resource
    private TrackRepository trackRepository;

    @Override
    public List<Track> getLastetTracks() {
        return trackRepository
                .findAll(new PageRequest(0, 100, Direction.DESC, "trackDate"))
                .getContent();
    }

    @Override
    public void buildFile() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //	Root element
            Document doc = docBuilder.newDocument();

            //	Playlist Element
            Element playlist = doc.createElement("playlist");

            Attr xmlns = doc.createAttribute("xmlns");
            xmlns.setValue("http://xspf.org/ns/0/");
            playlist.setAttributeNode(xmlns);

            Attr version = doc.createAttribute("version");
            version.setValue("1");
            playlist.setAttributeNode(version);

            //	Title Element
            Element title = doc.createElement("title");
            title.appendChild(doc.createTextNode("Podcast Alert"));

            //	trackList Element
            Element trackList = doc.createElement("trackList");

            //	title -> playlist
            playlist.appendChild(title);

            for(Track t : getLastetTracks()){
                //	playlist -> trackList -> track
                Element track = doc.createElement("track");
                CDATASection cdata;

                //	playlist -> trackList -> track -> location
                Element location = doc.createElement("location");
                location.appendChild(doc.createTextNode(t.getTrackLocation()));
                track.appendChild(location);

                //	playlist -> trackList -> track -> annotation
                cdata = doc.createCDATASection(t.getTrackTitle());
                Element annotation = doc.createElement("annotation");
                annotation.appendChild(cdata);
                track.appendChild(annotation);

                //	playlist -> trackList -> track -> creator
                Element creator = doc.createElement("creator");
                creator.appendChild(doc.createTextNode(
                        t.getPodcast().getPodcaster().getPodcasterName()));
                track.appendChild(creator);

                //	playlist -> trackList -> track -> album
                Element album = doc.createElement("album");
                album.appendChild(doc.createTextNode(
                        t.getPodcast().getPodcaster().getPodcasterName()));
                track.appendChild(album);

                //	playlist -> trackList -> track -> image
                Element image = doc.createElement("image");
                image.appendChild(doc.createTextNode(
                        t.getPodcast().getPodcastArtWork()));
                track.appendChild(image);

                //	playlist -> trackList -> track -> fecha
                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                String date = df.format(t.getTrackDate());
                Element fecha = doc.createElement("fecha");
                fecha.appendChild(doc.createTextNode(date));
                track.appendChild(fecha);

                //	playlist -> trackList -> track -> id
                Element id = doc.createElement("id");
                id.appendChild(doc.createTextNode(t.getPodcast().getCssClass()));
                track.appendChild(id);

                //	playlist -> trackList -> track
                trackList.appendChild(track);
            }

            //	playlist -> trackList
            playlist.appendChild(trackList);

            // root -> playlist
            doc.appendChild(playlist);

            //	Save file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("xspf\\playlist.xspf"));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
