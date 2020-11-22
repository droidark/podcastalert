package com.podcazity.podcastalert.model;

import lombok.Getter;
import lombok.Setter;

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
@Getter
@Setter
public class Podcast {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "podcast_id")
    private Integer podcastId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "podcaster_id")
    private Podcaster podcaster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "network_id")
    private Network network;

    @Column(name = "podcast_artwork")
    private String podcastArtWork;

    @Column(name = "podcast_url")
    private String podcastUrl;

    @Column(name = "podcast_description")
    private String podcastDescription;

    @Column(name = "podcast_feed")
    private String podcastFeed;

    @Column(name = "podcast_class")
    private String cssClass;

    @Column(name = "podcast_last_act")
    private Date podcastLastAct;

    @Column(name = "podcast_xmlfilename")
    private String podcastXmlFileName;

    @Column(name = "podcast_reader")
    private String podcastReader;

    @Column(name = "podcast_twitter")
    private String podcastTwitter;

    @Column(name = "podcast_facebook")
    private String podcastFacebook;

    @Column(name = "podcast_name")
    private String podcastName;

    @Column(name = "podcast_active")
    private boolean podcastActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "podcast", cascade = CascadeType.ALL)
    private Set<Track> tracks = new HashSet<>();
}
