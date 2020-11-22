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
@Table(name = "pdz_networks")
@Getter
@Setter
public class Network {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "network_id")
    private Integer networkId;

    @Column(name = "network_name")
    private String networkName;

    @Column(name = "network_description")
    private String networkDescription;

    @Column(name = "network_url")
    private String networkUrl;

    @Column(name = "network_twitter")
    private String networkTwitter;

    @Column(name = "network_facebook")
    private String networkFacebook;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "network")
    private Set<Podcast> podcasts = new HashSet<>();
}
