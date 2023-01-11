package com.anjaneya.profiles;

import com.anjaneya.profiles.cervice.WeatherService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProfilesApplication implements CommandLineRunner {

	private static final Logger logger = LogManager.getLogger(ProfilesApplication.class);

	@Autowired
	private WeatherService weatherService;

	public static void main(String[] args) {
		SpringApplication.run(ProfilesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(weatherService.forecast());

		logger.debug("Debugging log");
		logger.info("Info log");
		logger.warn("Hey, This is a warning!");
		logger.error("Oops! We have an Error. OK");
		logger.fatal("Damn! Fatal error. Please fix me.");
	}
}
