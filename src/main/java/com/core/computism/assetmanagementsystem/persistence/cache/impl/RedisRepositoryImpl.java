package com.core.computism.assetmanagementsystem.persistence.cache.impl;


import com.core.computism.assetmanagementsystem.domain.Location;
import com.core.computism.assetmanagementsystem.persistence.cache.RedisRepository;
import com.core.computism.assetmanagementsystem.util.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by M.Mustufa Amin  on 7/27/2015.
 */
@Repository(value = "redisRepository")
public class RedisRepositoryImpl implements RedisRepository {

    private static final Logger LOGGER = Logger.getLogger(RedisRepositoryImpl.class);
    private static final String PI_BOOKING_CAPTAIN_LOCATION_KEY = "HARMONY_BCL_";
    private final ObjectMapper mapper = JsonUtil.getMapper();

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public Location getCaptainLatestLocation(Integer captainId) {
        String key = "CAPTAIN_" + captainId;
        Location location = null;
        try {
            String jsonValue = (String) redisTemplate.opsForValue().get(key);

            if (StringUtils.isNotBlank(jsonValue)) {
                location = mapper.readValue(jsonValue, Location.class);
            }

        } catch (Exception e) {
            LOGGER.error("Error retrieving Captain Last Seen for key [" + key + "]", e);
        }
        return location;
    }

    private String getRepositoryKey(Integer bookingId) {
        return PI_BOOKING_CAPTAIN_LOCATION_KEY + bookingId;
    }
}
