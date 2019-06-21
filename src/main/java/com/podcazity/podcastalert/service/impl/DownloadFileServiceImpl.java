package com.podcazity.podcastalert.service.impl;

import com.podcazity.podcastalert.service.DownloadFeedService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;

@Service
public class DownloadFileServiceImpl implements DownloadFeedService {
    @Override
    public void downloadFile(String url, String filename) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File("xml\\" + filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
