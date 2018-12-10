package com.example.mdm;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@SpringBootApplication
public class MdmApplication {

    public static void main(String[] args) {
        SpringApplication.run(MdmApplication.class, args);
    }

    /*

    @Bean
    @ConfigurationProperties(prefix = "datasource.postgres")
    @Primary
    public DataSource localDataSource() {
        return DataSourceBuilder.create().build();
    }
    */

    /*
    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean localEntityManagerFactory(final EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(localDataSource())
                .packages("com.example.domain.local")
                .persistenceUnit("localPersistenceUnit")
                .build();
    }

    @Bean
    @Primary
    public JpaTransactionManager localTransactionManager(@Qualifier("localEntityManagerFactory") final EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }


    // secondary database
    @Bean
    @ConfigurationProperties(prefix = "datasource.vdb")
    public DataSource vdbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean vdbEntityManagerFactory(final EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(vdbDataSource())
                .packages("com.example.domain.vdb")
                .persistenceUnit("vdbPersistenceUnit")
                .build();
    }

    @Bean
    public JpaTransactionManager vdbTransactionManager(@Qualifier("vdbEntityManagerFactory") final EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }

    */
}
