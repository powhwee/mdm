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
@EntityScan("com.example.mdm.domain.vdb")
@EnableJpaRepositories(basePackages = {"com.example.mdm.repository.vdb"},
        entityManagerFactoryRef = VdbConfiguration.VDB_ENTITY_MANAGER_FACTORY, transactionManagerRef = VdbConfiguration.VDB_TRANSACTION_MANAGER)
@EnableTransactionManagement

public class VdbConfiguration {


    public static final String VDB_ENTITY_MANAGER_FACTORY = "vdbEntityManagerFactory";
    public static final String VDB_TRANSACTION_MANAGER = "vdbTransactionManager";

    @Bean
    @ConfigurationProperties(prefix = "datasource.vdb")
    // @Primary
    public DataSource vdbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    // @Primary
    public LocalContainerEntityManagerFactoryBean vdbEntityManagerFactory(final EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(vdbDataSource())
                .packages("com.example.mdm.domain.vdb")
                .persistenceUnit("vdbPersistenceUnit")
                .build();
    }

    @Bean
    // @Primary
    public JpaTransactionManager vdbTransactionManager(@Qualifier(VDB_ENTITY_MANAGER_FACTORY) final EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }

}
