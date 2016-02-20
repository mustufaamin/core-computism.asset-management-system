package com.core.computism.assasa.config;

import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * Created by Venturedive on 8/5/2015.
 */
@Configuration
@ComponentScan(value = "com.core.computism.assasa",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.REGEX, pattern = {"com.core.computism.assasa.web.*"}
        )
)
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setIgnoreUnresolvablePlaceholders(true);
        return configurer;
    }

    @Bean
    public DozerBeanMapperFactoryBean mapper() throws IOException {
        DozerBeanMapperFactoryBean dozerFactoryBean = new DozerBeanMapperFactoryBean();
        Resource[] mappingFiles = new PathMatchingResourcePatternResolver().getResources("classpath*:**/domain-mappings/*.xml");
        dozerFactoryBean.setMappingFiles(mappingFiles);
        return dozerFactoryBean;
    }
}
