package com.podcazity.podcastalert.service;

public interface UploadService {
	public void connect() throws Exception;
	public void uploadFile();
	public void disconnet();
}
