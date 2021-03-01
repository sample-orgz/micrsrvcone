package com.ynap.operations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableScheduling
public class MicrSrvcInstOneApplication {
	
	@Value("${app.application.environment}")
	private String appEnv;

	public static void main(String[] args) {
		SpringApplication.run(MicrSrvcInstOneApplication.class, args);		
	}
	
	@Bean
	public void getProfileInfo() {
		System.out.println(appEnv+" :: Environment picked up by the Service POD");
	}
	/*
	@Scheduled(fixedDelay = 5000, initialDelay = 10000)
	public void perform() {
		
		System.out.println("SAMPLE PROPERTY NAME::"+sampleName);
	}
	
	@Scheduled(fixedDelay = 5000, initialDelay = 10000)
	@Profile("development")
	public void process() {
		
		System.out.println("SAMPLE DEVELOPMENT PROPERTY NAME::"+sampleName);
	}
	*/
}
