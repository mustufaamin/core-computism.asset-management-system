package com.core.computism.assetmanagementsystem.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@EnableJpaRepositories(
        entityManagerFactoryRef = "bookingEntityManagerFactory",
        transactionManagerRef = "bookingTransactionManager",
        basePackages = "com.careem.harmony.brain.persistence.repository.booking"
)
public class BookingPersistenceConfig {

    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean(name = "bookingDataSource")
    DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(ApplicationProperties.MYSQL_DRIVER);
        dataSource.setJdbcUrl(applicationProperties.getCareemDBUrl());
        dataSource.setUser(applicationProperties.getCareemDBUsername());
        dataSource.setPassword( applicationProperties.getCareemDBPassword() );

        dataSource.setInitialPoolSize(2);
        dataSource.setMinPoolSize(2);
        dataSource.setAcquireIncrement(2);
        dataSource.setMaxPoolSize(ApplicationProperties.CAREEM_DB_POOLSIZE);
        dataSource.setMaxIdleTime(600);
        dataSource.setMaxIdleTimeExcessConnections(190);
        dataSource.setMaxConnectionAge(720);
        dataSource.setIdleConnectionTestPeriod(300);

        dataSource.setPreferredTestQuery("select 1");
        dataSource.setTestConnectionOnCheckin(false);
        dataSource.setTestConnectionOnCheckout(true);

        return dataSource;
    }

    @Bean(name = "bookingEntityManagerFactory")
    EntityManagerFactory entityManagerFactory() throws PropertyVetoException {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setPersistenceUnitName("bookingPersistenceUnit");
        factory.setPackagesToScan("com.careem.harmony.brain.persistence.entity.booking");
        factory.setDataSource(dataSource());
        factory.setJpaVendorAdapter(jpaVendorAdapter);
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean(name = "bookingTransactionManager")
    PlatformTransactionManager transactionManager() throws PropertyVetoException  {
        return new JpaTransactionManager(entityManagerFactory());
    }
}
