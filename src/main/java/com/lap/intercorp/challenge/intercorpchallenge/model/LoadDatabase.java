package com.lap.intercorp.challenge.intercorpchallenge.model;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lap.intercorp.challenge.intercorpchallenge.IntercorpchallengeApplication;

@Configuration

class LoadDatabase {
  private static final Logger log = LoggerFactory.getLogger(IntercorpchallengeApplication.class);

  @Bean
  CommandLineRunner initDatabase(ClientRepository repo) {
    return args -> {
    	log.info("Start service");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	log.info("Save: " + repo.save(new Client("Linus", "Torvals", 49, sdf.parse("1969-12-28"))));
		log.info("Save: " + repo.save(new Client("Richard", "Stallman", 66, sdf.parse("1953-03-16"))));
    };
  }
}