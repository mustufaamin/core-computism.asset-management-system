package com.core.computism.assasa.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Hold all the properties from VM Options.
 * Created by Venturedive on 7/28/2015.
 */
@Component
public class ApplicationProperties {

    private static final Logger LOGGER = Logger.getLogger(ApplicationProperties.class);

    public static final String SQS_ACCESS_KEY = "AKIAIAL36MTVOWERWYRQ";
    public static final String SQS_SECRET_KEY = "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";

    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static final Integer ASSASA_DB_POOLSIZE = 5;

    public static final int REDIS_PORT = 6379;
    public static final int REDIS_TIMEOUT_SEC = 3600;

    private @Value("${CONFIG_ENV:DEV}") String configEnv;

    private @Value("${REDIS.ENDPOINT}") String redisEndPoint;

    // Debug Mode Properties
    private @Value("${HARMONY.BRAIN.DEBUG_MODE:false}") boolean isDebugMode;
    private boolean showSql = isDebugMode;

    // Amazon SQS Properties
    private @Value("${SQS.PROBLEM.QUEUE}") String sqsProblemQueueName;

    // Assasa
    private @Value("${ASSASA.DB.ENDPOINT}") String assasaDBEndPoint;
    private @Value("${ASSASA.DB.USERNAME}") String assasaDBUsername;
    private @Value("${ASSASA.DB.PASSWORD}") String assasaDBPassword;
    private @Value("${ASSASA.DB.NAME}") String ASSASA_DB;

    // Application EndPoints
    private @Value("${HARMONY.PI.ENDPOINT}") String problemIdentifierEndpoint;

    @PostConstruct
    public void info() {
        LOGGER.info("Loaded application properties for Configuration Environment [" + configEnv + "], with Debug Mode [" + isDebugMode() + "]");
    }

    public boolean isDebugMode() {
        return isDebugMode;
    }

    public String getSqsProblemQueueName() {
        return sqsProblemQueueName;
    }

    public boolean isShowSql() {
        return showSql;
    }



    public String getAssasaDBUrl(){
        return "jdbc:mysql://" + assasaDBEndPoint + "/" + ASSASA_DB +"?characterEncoding=UTF-8&amp;useUnicode=true";
    }


    public String getTicketVerificationUrl() {
        return "http://" + problemIdentifierEndpoint + "/pi/verify";
    }

    public String getRedisEndPoint() {
        return redisEndPoint;
    }

    public String getAssasaDBUsername() {
        return assasaDBUsername;
    }

    public void setAssasaDBUsername(String assasaDBUsername) {
        this.assasaDBUsername = assasaDBUsername;
    }

    public String getAssasaDBEndPoint() {
        return assasaDBEndPoint;
    }

    public void setAssasaDBEndPoint(String assasaDBEndPoint) {
        this.assasaDBEndPoint = assasaDBEndPoint;
    }

    public String getAssasaDBPassword() {
        return assasaDBPassword;
    }

    public void setAssasaDBPassword(String assasaDBPassword) {
        this.assasaDBPassword = assasaDBPassword;
    }
}
