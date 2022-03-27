package com.ram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application extends SpringBootServletInitializer {

	private static final Logger logger = LogManager.getLogger(Application.class);

	public static void main(String[] args) {
		new Application().configure(new SpringApplicationBuilder(Application.class)).run(args);
	}

	public void run(ApplicationArguments applicationArguments) throws Exception {
		logger.debug("Debugging log");
		logger.info("Info log CHECKING");
		logger.warn("Hey, This is a warning!");
		logger.error("Oops! We have an Error. OK");
		logger.fatal("Damn! Fatal error. Please fix me.");
	}

}
