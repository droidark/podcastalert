package com.podcazity.podcastalert.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pdz_podcasters")
public class Podcaster {
    private Integer podcasterId;
    private String podcasterName;
    private String podcasterUrl;
    private String podcasterShortDescription;
    private String podcasterAvatar;
    private Set<Podcast> podcasts = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "podcaster_id")
    public Integer getPodcasterId() {
        return podcasterId;
    }
    public void setPodcasterId(Integer podcasterId) {
        this.podcasterId = podcasterId;
    }

    @Column(name = "podcaster_name")
    public String getPodcasterName() {
        return podcasterName;
    }
    public void setPodcasterName(String podcasterName) {
        this.podcasterName = podcasterName;
    }

    @Column(name = "podcaster_url")
    public String getPodcasterUrl() {
        return podcasterUrl;
    }
    public void setPodcasterUrl(String podcasterUrl) {
        this.podcasterUrl = podcasterUrl;
    }

    @Column(name = "podcaster_short_description")
    public String getPodcasterShortDescription() {
        return podcasterShortDescription;
    }
    public void setPodcasterShortDescription(String podcasterShortDescription) {
        this.podcasterShortDescription = podcasterShortDescription;
    }

    @Column(name = "podcaster_avatar")
    public String getPodcasterAvatar() {
        return podcasterAvatar;
    }
    public void setPodcasterAvatar(String podcasterAvatar) {
        this.podcasterAvatar = podcasterAvatar;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "podcaster")
    public Set<Podcast> getPodcasts() {
        return podcasts;
    }
    public void setPodcasts(Set<Podcast> podcasts) {
        this.podcasts = podcasts;
    }
}
