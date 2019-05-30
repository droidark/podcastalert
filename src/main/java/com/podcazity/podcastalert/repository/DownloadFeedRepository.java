package com.podcazity.podcastalert.repository;

public interface DownloadFeedRepository {
    void downloadFile(String url, String filename);
}
