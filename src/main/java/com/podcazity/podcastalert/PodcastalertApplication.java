package com.podcazity.podcastalert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PodcastalertApplication {

    private static final Logger logger = LoggerFactory.getLogger(PodcastalertApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PodcastalertApplication.class, args);
        logger.info("#PodcastAlet proccess begings");
    }

}
