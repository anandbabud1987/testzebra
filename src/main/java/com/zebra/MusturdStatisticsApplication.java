package com.zebra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * This is the entry point of the spring boot rest api project.
 * @author anand
 *
 */
@SpringBootApplication
@ComponentScan("com.zebra.*")
@EnableAutoConfiguration
@Configuration
@EnableTransactionManagement
@EntityScan("com.zebra.entity")
public class MusturdStatisticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusturdStatisticsApplication.class, args);
	}
}
