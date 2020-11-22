package com.podcazity.podcastalert.model;

import lombok.Getter;
import lombok.Setter;

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
@Getter
@Setter
public class Podcaster {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "podcaster_id")
    private Integer podcasterId;

    @Column(name = "podcaster_name")
    private String podcasterName;

    @Column(name = "podcaster_url")
    private String podcasterUrl;

    @Column(name = "podcaster_short_description")
    private String podcasterShortDescription;

    @Column(name = "podcaster_avatar")
    private String podcasterAvatar;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "podcaster")
    private Set<Podcast> podcasts = new HashSet<>();
}
