package com.core.computism.assasa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Salman on 8/5/2015.
 */
@Configuration
@Import(AppConfig.class)
public class TestConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setIgnoreUnresolvablePlaceholders(true);
        configurer.setProperties(testProperties());
        return configurer;
    }

    @Bean
    public static Properties testProperties() {
        Properties properties = new Properties();
        properties.put("CONFIG_ENV", "TEST");
        properties.put("HARMONY.BRAIN.DEBUG_MODE", "true");

        return properties;
    }

    @Bean(name = {"bookingDataSource", "ticketDataSource"})
    DataSource dataSource() {
        return new DriverManagerDataSource();
    }
}
