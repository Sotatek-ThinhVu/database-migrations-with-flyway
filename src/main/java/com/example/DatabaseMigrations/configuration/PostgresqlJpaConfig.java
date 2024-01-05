package com.example.DatabaseMigrations.configuration;

import com.example.DatabaseMigrations.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "postgresqlEntityManagerFactory",
        transactionManagerRef = "postgresqlTransactionManager",
        basePackages = {
                "com.example.DatabaseMigrations.repository.postgresql"
        }
)
public class PostgresqlJpaConfig {
    @Value("${spring.jpa.postgresql.properties.hibernate.dialect}")
    private String hibernateDialect;
    @Bean(name = "postgresqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean postgresqlEntityManagerFactory(
            @Qualifier("postgresqlDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        Map<String, String> jpaProperties = new HashMap<>();
        jpaProperties.put("hibernate.dialect",hibernateDialect);
        return builder
                .dataSource(dataSource)
                .packages(User.class)
                .properties(jpaProperties)
                .build();
    }

    @Bean(name = "postgresqlTransactionManager")
    public PlatformTransactionManager postgresqlTransactionManager(
            @Qualifier("postgresqlEntityManagerFactory") LocalContainerEntityManagerFactoryBean postgresqlEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(postgresqlEntityManagerFactory.getObject()));
    }
}
