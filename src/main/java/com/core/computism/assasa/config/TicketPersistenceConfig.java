package com.core.computism.assasa.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by Venturedive on 8/10/2015.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
@EnableJpaRepositories(
        entityManagerFactoryRef = "ticketEntityManagerFactory",
        transactionManagerRef = "ticketTransactionManager",
        basePackages = "com.core.computism.assasa.persistence.repository.ticket"
)
public class TicketPersistenceConfig {

    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean(name = "ticketDataSource")
    @Primary
    DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(ApplicationProperties.MYSQL_DRIVER);
        dataSource.setJdbcUrl(applicationProperties.getHarmonyDBUrl());
        dataSource.setUser(applicationProperties.getHarmonyDBUsername());
        dataSource.setPassword( applicationProperties.getHarmonyDBPassword() );

        dataSource.setInitialPoolSize(5);
        dataSource.setMinPoolSize(5);
        dataSource.setAcquireIncrement(2);
        dataSource.setMaxPoolSize(ApplicationProperties.HARMONY_DB_POOLSIZE);
        dataSource.setMaxIdleTime(600);
        dataSource.setMaxIdleTimeExcessConnections(190);
        dataSource.setMaxConnectionAge(720);
        dataSource.setIdleConnectionTestPeriod(300);

        dataSource.setPreferredTestQuery("select 1");
        dataSource.setTestConnectionOnCheckin(false);
        dataSource.setTestConnectionOnCheckout(true);

        return dataSource;
    }

    @Bean(name = "ticketEntityManagerFactory")
    EntityManagerFactory harmomyEntityManagerFactory() throws PropertyVetoException {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setPersistenceUnitName("ticketPersistenceUnit");
        factory.setPackagesToScan("com.core.computism.assasa.persistence.entity.ticket");
        factory.setDataSource(dataSource());
        factory.setJpaVendorAdapter(jpaVendorAdapter);
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean(name = "ticketTransactionManager")
    @Primary
    PlatformTransactionManager transactionManager() throws PropertyVetoException {
        return new JpaTransactionManager(harmomyEntityManagerFactory());
    }
}
