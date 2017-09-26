package com.podcazity.podcastalert.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.podcazity.podcastalert.service.UploadService;

@Service("uploadService")
@PropertySource(value = {"ftp.properties"})
public class UploadServiceImpl implements UploadService {

	@Value("${ftp.server}")
	private String host;
	
	@Value("${ftp.user}")
	private String user;
	
	@Value("${ftp.password}")
	private String pwd;
	
	@Value("${ftp.origin}")
	private String origin;
	
	@Value("${ftp.destination}")
	private String destination;
	
	private FTPClient ftp = new FTPClient();
	
	@Override
	public void connect() throws Exception {
		int reply;
		ftp.addProtocolCommandListener(
				new PrintCommandListener(new PrintWriter(System.out)));
		ftp.connect(host);
		reply = ftp.getReplyCode();
		if(!FTPReply.isPositiveCompletion(reply)){
            ftp.disconnect();
            throw new Exception("Exception is connecting to FTP Server");
        }
		ftp.login(user, pwd);
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        ftp.enterLocalPassiveMode();
	}
	
	@Override
	public void uploadFile() {
		try{
			this.connect();
        	InputStream input = new FileInputStream(new File(origin));
        	this.ftp.storeFile(destination, input);
        	this.disconnet();
        } catch(Exception e){
        	e.printStackTrace();
        }		
	}

	@Override
	public void disconnet() {
		if(this.ftp.isConnected()){
            try{
                this.ftp.logout();
                this.ftp.disconnect();
            } catch(Exception f){
                f.printStackTrace();
            }
        }		
	}

}
