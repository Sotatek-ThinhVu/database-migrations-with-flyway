package com.example.DatabaseMigrations.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
@Configuration
public class PostgresqlDataSourceConfig {
    @Bean(name = "postgresqlDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.postgresql")
    public DataSource postgresqlDataSource() {
        return DataSourceBuilder.create()
                .build();
    }

}
