package com.podcazity.podcastalert.service.impl;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import org.springframework.stereotype.Service;

import com.podcazity.podcastalert.service.DownloadFeedService;

@Service("downloadFeedService")
public class DownloadFeedServiceImpl implements DownloadFeedService {

	@Override
	public void downloadFile(String url, String filename) {
		try {
			URL feedLocation = new URL(url);
			ReadableByteChannel rbc = Channels.newChannel(feedLocation.openStream());
			FileOutputStream fos = new FileOutputStream("C:\\virux\\" + filename);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
			rbc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
