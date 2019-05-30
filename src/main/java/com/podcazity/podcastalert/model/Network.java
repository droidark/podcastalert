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
@Table(name = "pdz_networks")
public class Network {
    private Integer networkId;
    private String networkName;
    private String networkDescription;
    private String networkUrl;
    private String networkTwitter;
    private String networkFacebook;
    private Set<Podcast> podcasts = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "network_id")
    public Integer getNetworkId() {
        return networkId;
    }
    public void setNetworkId(Integer networkId) {
        this.networkId = networkId;
    }

    @Column(name = "network_name")
    public String getNetworkName() {
        return networkName;
    }
    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    @Column(name = "network_description")
    public String getNetworkDescription() {
        return networkDescription;
    }
    public void setNetworkDescription(String networkDescription) {
        this.networkDescription = networkDescription;
    }

    @Column(name = "network_url")
    public String getNetworkUrl() {
        return networkUrl;
    }
    public void setNetworkUrl(String networkUrl) {
        this.networkUrl = networkUrl;
    }

    @Column(name = "network_twitter")
    public String getNetworkTwitter() {
        return networkTwitter;
    }
    public void setNetworkTwitter(String networkTwitter) {
        this.networkTwitter = networkTwitter;
    }

    @Column(name = "network_facebook")
    public String getNetworkFacebook() {
        return networkFacebook;
    }
    public void setNetworkFacebook(String networkFacebook) {
        this.networkFacebook = networkFacebook;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "network")
    public Set<Podcast> getPodcasts() {
        return podcasts;
    }
    public void setPodcasts(Set<Podcast> podcasts) {
        this.podcasts = podcasts;
    }
}
