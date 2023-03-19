package com.itm.serviceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class ServiceapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ServiceapiApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello i am working here");
    }
}
