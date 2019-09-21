package com.lap.intercorp.challenge.intercorpchallenge;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lap.intercorp.challenge.intercorpchallenge.model.Client;
import com.lap.intercorp.challenge.intercorpchallenge.model.ClientRepository;

@SpringBootApplication
public class IntercorpchallengeApplication {
	
	private static final Logger log = LoggerFactory.getLogger(IntercorpchallengeApplication.class);
	
	@Autowired
	private  ClientRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(IntercorpchallengeApplication.class, args);
	}
	
	public void run(String... args) {
		log.info("Start service");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			log.info("Save: " + repo.save(new Client("Linus", "Torvals", 49, sdf.parse("1969-12-28"))));
			log.info("Save: " + repo.save(new Client("Richard", "Stallman", 66, sdf.parse("1953-03-16"))));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
