package com.core.computism.assetmanagementsystem.persistence.cache;


import com.core.computism.assetmanagementsystem.domain.Location;

/**
 * Created by Venturedive on 7/27/2015.
 */
public interface RedisRepository {

   Location getCaptainLatestLocation(Integer captainId);
}
