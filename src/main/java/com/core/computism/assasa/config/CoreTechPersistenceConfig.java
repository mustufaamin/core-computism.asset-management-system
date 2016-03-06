package com.core.computism.assasa.config;

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
 * Created by VD on 2/20/2016.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "coreTechEntityManagerFactory",
        transactionManagerRef = "coreTechTransactionManager",
        basePackages = "com.core.computism.assasa.ar.repository"
)
public class CoreTechPersistenceConfig {

    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean(name = "coreTechDataSource")
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

    @Bean(name = "coreTechEntityManagerFactory")
    EntityManagerFactory entityManagerFactory() throws PropertyVetoException {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setPersistenceUnitName("coreTechPersistenceUnit");
        factory.setPackagesToScan("com.core.computism.assasa.ar.entity.account");
        factory.setDataSource(dataSource());
        factory.setJpaVendorAdapter(jpaVendorAdapter);
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean(name = "coreTechTransactionManager")
    PlatformTransactionManager transactionManager() throws PropertyVetoException  {
        return new JpaTransactionManager(entityManagerFactory());
    }
}
