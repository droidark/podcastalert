package com.podcazity.podcastalert.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.podcazity.podcastalert.model.Podcaster;
import com.podcazity.podcastalert.repository.PodcasterRepository;
import com.podcazity.podcastalert.service.PodcasterService;

@Service("podcasterService")
public class PodcasterServiceImpl implements PodcasterService{
	
	@Resource 
	private PodcasterRepository podcasterRepository;

	@Override
	public Podcaster save(Podcaster podcaster) {
		return podcasterRepository.save(podcaster);
	}

	@Override
	public void delete(Podcaster podcaster) {
		podcasterRepository.delete(podcaster);
		
	}

	@Override
	public List<Podcaster> findAll() {
		return podcasterRepository.findAll();
	}

	

}
