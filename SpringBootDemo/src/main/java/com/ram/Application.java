package com.ram;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new Application().configure(new SpringApplicationBuilder(Application.class)).run(args);
	}

}
