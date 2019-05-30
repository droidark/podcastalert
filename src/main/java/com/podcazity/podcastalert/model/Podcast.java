package com.podcazity.podcastalert.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pdz_podcasts")
public class Podcast {
    private Integer podcastId;
    private Podcaster podcaster;
    private Network network;
    private String podcastArtWork;
    private String podcastUrl;
    private String podcastDescription;
    private String podcastFeed;
    private String cssClass;
    private Date podcastLastAct;
    private String podcastXmlFileName;
    private String podcastReader;
    private String podcastTwitter;
    private String podcastFacebook;
    private String podcastName;
    private boolean podcastActive;
    private Set<Track> tracks = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "podcast_id")
    public Integer getPodcastId() {
        return podcastId;
    }
    public void setPodcastId(Integer podcastId) {
        this.podcastId = podcastId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "podcaster_id", nullable = true)
    public Podcaster getPodcaster() {
        return podcaster;
    }
    public void setPodcaster(Podcaster podcaster) {
        this.podcaster = podcaster;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "network_id", nullable = true)
    public Network getNetwork() {
        return network;
    }
    public void setNetwork(Network network) {
        this.network = network;
    }
    @Column(name = "podcast_artwork")
    public String getPodcastArtWork() {
        return podcastArtWork;
    }
    public void setPodcastArtWork(String podcastArtWork) {
        this.podcastArtWork = podcastArtWork;
    }

    @Column(name = "podcast_url")
    public String getPodcastUrl() {
        return podcastUrl;
    }
    public void setPodcastUrl(String podcastUrl) {
        this.podcastUrl = podcastUrl;
    }

    @Column(name = "podcast_description")
    public String getPodcastDescription() {
        return podcastDescription;
    }
    public void setPodcastDescription(String podcastDescription) {
        this.podcastDescription = podcastDescription;
    }

    @Column(name = "podcast_feed")
    public String getPodcastFeed() {
        return podcastFeed;
    }
    public void setPodcastFeed(String podcastFeed) {
        this.podcastFeed = podcastFeed;
    }

    @Column(name = "podcast_class")
    public String getCssClass() {
        return cssClass;
    }
    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    @Column(name = "podcast_last_act")
    public Date getPodcastLastAct() {
        return podcastLastAct;
    }
    public void setPodcastLastAct(Date podcastLastAct) {
        this.podcastLastAct = podcastLastAct;
    }

    @Column(name = "podcast_xmlfilename")
    public String getPodcastXmlFileName() {
        return podcastXmlFileName;
    }
    public void setPodcastXmlFileName(String podcastXmlFileName) {
        this.podcastXmlFileName = podcastXmlFileName;
    }

    @Column(name = "podcast_reader")
    public String getPodcastReader() {
        return podcastReader;
    }
    public void setPodcastReader(String podcastReader) {
        this.podcastReader = podcastReader;
    }

    @Column(name = "podcast_twitter")
    public String getPodcastTwitter() {
        return podcastTwitter;
    }
    public void setPodcastTwitter(String podcastTwitter) {
        this.podcastTwitter = podcastTwitter;
    }

    @Column(name = "podcast_facebook")
    public String getPodcastFacebook() {
        return podcastFacebook;
    }
    public void setPodcastFacebook(String podcastFacebook) {
        this.podcastFacebook = podcastFacebook;
    }

    @Column(name = "podcast_name")
    public String getPodcastName() {
        return podcastName;
    }
    public void setPodcastName(String podcastName) {
        this.podcastName = podcastName;
    }

    @Column(name = "podcast_active")
    public boolean isPodcastActive() {
        return podcastActive;
    }
    public void setPodcastActive(boolean podcastActive) {
        this.podcastActive = podcastActive;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "podcast", cascade = CascadeType.ALL)
    public Set<Track> getTracks() {
        return tracks;
    }
    public void setTracks(Set<Track> tracks) {
        this.tracks = tracks;
    }
}
