package com.core.computism.assasa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Salman on 8/11/2015.
 */
@Configuration
@ComponentScan
@EnableTransactionManagement
public class PersistenceConfig {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean
    HibernateJpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(Boolean.FALSE);
        jpaVendorAdapter.setShowSql(applicationProperties.isShowSql());
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
        return jpaVendorAdapter;
    }

    @Bean
    RedisTemplate<String, String> redisTemplate() {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String,String>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setKeySerializer(redisSerializer());
        redisTemplate.setValueSerializer(redisSerializer());
        return redisTemplate;
    }

    @Bean
    StringRedisSerializer redisSerializer() {
        return new StringRedisSerializer();
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(applicationProperties.getRedisEndPoint());
        factory.setPort(ApplicationProperties.REDIS_PORT);
        factory.setTimeout(ApplicationProperties.REDIS_TIMEOUT_SEC);
        factory.setUsePool(true);
        return factory;
    }
}
