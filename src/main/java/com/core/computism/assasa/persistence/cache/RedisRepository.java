package com.core.computism.assasa.persistence.cache;


import com.core.computism.assasa.domain.Location;

/**
 * Created by Mustufa Amin on 7/27/2015.
 */
public interface RedisRepository {

   Location getCaptainLatestLocation(Integer captainId);
}
