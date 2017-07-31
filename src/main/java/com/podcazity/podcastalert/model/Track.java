package com.podcazity.podcastalert.model;

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
public class Track {
	private Integer trackId;
	private Podcast podcast;
	private String trackLocation;
	private String trackIdentifier;
	private String trackTitle;
	private String trackAnnotation;
	private String trackImage;
	private Integer trackTrackNum;
	private Integer trackDuration;
	private Date trackDate;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "track_id")
	public Integer getTrackId() {
		return trackId;
	}
	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "podcast_id", nullable = false)
	public Podcast getPodcast() {
		return podcast;
	}
	public void setPodcast(Podcast podcast) {
		this.podcast = podcast;
	}
	
	@Column(name = "track_location")
	public String getTrackLocation() {
		return trackLocation;
	}
	public void setTrackLocation(String trackLocation) {
		this.trackLocation = trackLocation;
	}
	
	@Column(name = "track_identifier")
	public String getTrackIdentifier() {
		return trackIdentifier;
	}
	public void setTrackIdentifier(String trackIdentifier) {
		this.trackIdentifier = trackIdentifier;
	}
	
	@Column(name = "track_title")
	public String getTrackTitle() {
		return trackTitle;
	}
	public void setTrackTitle(String trackTitle) {
		this.trackTitle = trackTitle;
	}
	
	@Column(name = "track_annotation")
	public String getTrackAnnotation() {
		return trackAnnotation;
	}
	public void setTrackAnnotation(String trackAnnotation) {
		this.trackAnnotation = trackAnnotation;
	}
	
	@Column(name = "track_image")
	public String getTrackImage() {
		return trackImage;
	}
	public void setTrackImage(String trackImage) {
		this.trackImage = trackImage;
	}
	
	@Column(name = "track_tracknum")
	public Integer getTrackTrackNum() {
		return trackTrackNum;
	}
	public void setTrackTrackNum(Integer trackTrackNum) {
		this.trackTrackNum = trackTrackNum;
	}
	
	@Column(name = "track_duration")
	public Integer getTrackDuration() {
		return trackDuration;
	}
	public void setTrackDuration(Integer trackDuration) {
		this.trackDuration = trackDuration;
	}
	
	@Column(name = "track_date")
	public Date getTrackDate() {
		return trackDate;
	}
	public void setTrackDate(Date trackDate) {
		this.trackDate = trackDate;
	}
}
