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

    @Value("${firstDatasource.db.url}")
    String firstDatasourceUrl;
    @Value("${firstDatasource.db.user}")
    String firstDatasourceUser;
    @Value("${firstDatasource.db.password}")
    String firstDatasourcePassword;

    @Value("${firstDatasource.db.locations}")
    String firstDatasourceLocations;

    @Value("${secondDatasource.db.url}")
    String secondDatasourceUrl;
    @Value("${secondDatasource.db.user}")
    String secondDatasourceUser;
    @Value("${secondDatasource.db.password}")
    String secondDatasourcePassword;

    @Value("${secondDatasource.db.locations}")
    String secondDatasourceLocations;
    @PostConstruct
    public void migrateFlyway() {
        Flyway flywayIntegration = Flyway.configure()
                .dataSource(firstDatasourceUrl, firstDatasourceUser, firstDatasourcePassword)
                .outOfOrder(true)
                .locations(firstDatasourceLocations)
                .load();

        Flyway flywayPhenom = Flyway.configure()
                .dataSource(secondDatasourceUrl, secondDatasourceUser, secondDatasourcePassword)
                .outOfOrder(true)
                .locations(secondDatasourceLocations)
                .load();

        flywayIntegration.migrate();
        flywayPhenom.migrate();
        logger.info("Run Flywayyyyyyyyyyyyyyyyyyyyyyyyy");
    }
}
