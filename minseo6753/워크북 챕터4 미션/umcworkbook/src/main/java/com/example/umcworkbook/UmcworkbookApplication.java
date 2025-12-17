package com.example.umcworkbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UmcworkbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(UmcworkbookApplication.class, args);
	}

}
