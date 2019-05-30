package com.podcazity.podcastalert.repository.impl;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Repository;

import com.podcazity.podcastalert.repository.DownloadFeedRepository;

@Repository("downloadFeedRepository")
public class DownloadFeedRepositoryImpl implements DownloadFeedRepository {

    @Override
    public void downloadFile(String url, String filename) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File("xml\\" + filename));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
