package com.podcazity.podcastalert.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.podcazity.podcastalert.model.Track;
import com.podcazity.podcastalert.repository.TrackRepository;
import com.podcazity.podcastalert.service.TrackService;

public class TrackServiceImpl implements TrackService{
	
	@Resource
	private TrackRepository trackRepository;

	@Override
	public Track save(Track track) {
		return trackRepository.save(track);
	}

	@Override
	public void delete(Track track) {
		trackRepository.delete(track);
		
	}

	@Override
	public List<Track> findAll() {
		return trackRepository.findAll();
	}

}
