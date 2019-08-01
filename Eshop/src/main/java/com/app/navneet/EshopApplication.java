package com.app.navneet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.app.navneet")
@EntityScan("com.app.navneet.model")
public class EshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(EshopApplication.class, args);
	}


}
