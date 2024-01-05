package com.example.DatabaseMigrations;

import com.example.DatabaseMigrations.configuration.FlywaySlaveInitializer;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DatabaseMigrationsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DatabaseMigrationsApplication.class, args);
		FlywaySlaveInitializer flywaySlaveInitializer = context.getBean(FlywaySlaveInitializer.class);
		//SpringApplication.run(DatabaseMigrationsApplication.class, args);
	}

}
