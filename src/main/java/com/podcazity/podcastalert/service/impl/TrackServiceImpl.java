package com.podcazity.podcastalert.service.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.podcazity.podcastalert.model.Track;
import com.podcazity.podcastalert.repository.TrackRepository;
import com.podcazity.podcastalert.service.TrackService;

@Service("trackService")
public class TrackServiceImpl implements TrackService{
	
	@Resource
	private TrackRepository trackRepository;

	@Override
	public Track save(Track track) {
		if(trackRepository.findBytrackLocation(track.getTrackLocation()) == null) {
			return trackRepository.save(track);
		}
		return null;
	}

	@Override
	public void delete(Track track) {
		trackRepository.delete(track);
		
	}

	@Override
	public Page<Track> listAllByPage(Pageable pageable) {
		return trackRepository.findAll(pageable);
	}


	
}
