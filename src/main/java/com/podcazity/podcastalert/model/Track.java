package com.podcazity.podcastalert.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pdz_tracks")
@Getter
@Setter
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "track_id")
    private Integer trackId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "podcast_id", nullable = false)
    private Podcast podcast;

    @Column(name = "track_location")
    private String trackLocation;

    @Column(name = "track_identifier")
    private String trackIdentifier;

    @Column(name = "track_title")
    private String trackTitle;

    @Column(name = "track_annotation")
    private String trackAnnotation;

    @Column(name = "track_image")
    private String trackImage;

    @Column(name = "track_tracknum")
    private Integer trackTrackNum;

    @Column(name = "track_duration")
    private Integer trackDuration;

    @Column(name = "track_date")
    private Date trackDate;

    @Column(name = "track_page")
    private String trackPage;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((trackLocation == null) ? 0 : trackLocation.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Track other = (Track) obj;
        if (trackLocation == null) {
            return other.trackLocation == null;
        } else return trackLocation.equals(other.trackLocation);
    }
}
