package com.podcazity.podcastalert.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.podcazity.podcastalert.model.Podcast;
import com.podcazity.podcastalert.repository.PodcastRepository;
import com.podcazity.podcastalert.service.PodcastService;

@Service("podcastService")
public class PodcastServiceImpl implements PodcastService{
	
	@Resource
	private PodcastRepository podcastRepository;

	@Override
	public Podcast save(Podcast podcast) {
		return podcastRepository.save(podcast);
	}

	@Override
	public void delete(Podcast podcast) {
		podcastRepository.delete(podcast);
	}

	@Override
	public List<Podcast> findAll() {
		return podcastRepository.findAll();
	}

}
