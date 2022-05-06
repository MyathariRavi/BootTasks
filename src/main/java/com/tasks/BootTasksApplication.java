package com.tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BootTasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootTasksApplication.class, args);
	}

}
