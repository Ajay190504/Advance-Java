package com.springstart.demoproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoprojApplication {

	public static void main(String[] args) {
		
		
		ApplicationContext context = SpringApplication.run(DemoprojApplication.class, args);
		
		Dev obj = context.getBean(Dev.class);
		
		obj.building();
	}

}
