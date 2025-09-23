package com.example.RESTapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication
@EnableTransactionManagement
public class MainApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);
		ConfigurableEnvironment environment = context.getEnvironment();
		log.info(environment.getActiveProfiles()[0]);
	}
	@Bean
   public PlatformTransactionManager add(MongoDatabaseFactory dbFactroy){
		return new MongoTransactionManager(dbFactroy);
   }
}
