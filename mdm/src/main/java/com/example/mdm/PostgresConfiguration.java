package com.example.mdm;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories(basePackages = {"com.example.mdm.repository.local"},
        entityManagerFactoryRef = PostgresConfiguration.POSTGRES_ENTITY_MANAGER_FACTORY, transactionManagerRef = PostgresConfiguration.POSTGRES_TRANSACTION_MANAGER)
@EnableTransactionManagement


public class PostgresConfiguration {


    public static final String POSTGRES_ENTITY_MANAGER_FACTORY = "localEntityManagerFactory";
    public static final String POSTGRES_TRANSACTION_MANAGER = "localTransactionManager";

    @Bean
    @ConfigurationProperties(prefix = "datasource.postgres")
    @Primary
    public DataSource localDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean localEntityManagerFactory(final EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(localDataSource())
                .packages("com.example.mdm.domain.local")
                .persistenceUnit("localPersistenceUnit")
                .build();
    }

    @Bean
    @Primary
    public JpaTransactionManager localTransactionManager(@Qualifier(POSTGRES_ENTITY_MANAGER_FACTORY) final EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }

}