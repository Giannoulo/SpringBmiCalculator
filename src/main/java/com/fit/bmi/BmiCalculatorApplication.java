package com.fit.bmi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BmiCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmiCalculatorApplication.class, args);
	}

}
