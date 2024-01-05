package com.example.DatabaseMigrations.configuration;

import jakarta.annotation.PostConstruct;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywaySlaveInitializer {

    private Logger logger = LoggerFactory.getLogger(FlywaySlaveInitializer.class);

    @Value("${spring.datasource.postgresql.jdbc-url}")
    String firstDatasourceUrl;
    @Value("${spring.datasource.postgresql.username}")
    String firstDatasourceUser;
    @Value("${spring.datasource.postgresql.password}")
    String firstDatasourcePassword;

    @Value("${spring.datasource.postgresql.flyway.locations}")
    String firstDatasourceLocations;

    @Value("${spring.datasource.mysql.jdbc-url}")
    String secondDatasourceUrl;
    @Value("${spring.datasource.mysql.username}")
    String secondDatasourceUser;
    @Value("${spring.datasource.mysql.password}")
    String secondDatasourcePassword;

    @Value("${spring.flyway.enabled}")
    Boolean onMigrate;

    @Value("${spring.datasource.mysql.flyway.locations}")
    String secondDatasourceLocations;
    @PostConstruct
    public void migrateFlyway() {
        Flyway flywayIntegration = Flyway.configure()
                .dataSource(firstDatasourceUrl, firstDatasourceUser, firstDatasourcePassword)
                .outOfOrder(true)
                .locations(firstDatasourceLocations)
                .validateOnMigrate(false)
                .load();

        Flyway flywayPhenom = Flyway.configure()
                .dataSource(secondDatasourceUrl, secondDatasourceUser, secondDatasourcePassword)
                .outOfOrder(true)
                .locations(secondDatasourceLocations)
                .validateOnMigrate(false)
                .load();

        if(onMigrate){
            flywayIntegration.migrate();
            flywayPhenom.migrate();
        }
    }
}
