package com.core.computism.assasa.persistence.repository.pos;

import com.core.computism.assasa.persistence.entity.pos.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by M.Mustafa Amin on 3/13/2016.
 */
public interface CityRepository extends JpaRepository<City,Long> {

    @Query("from City c where c.country.id = :countryId")
    List<City> findCityByCountryId(@Param("countryId") Long bookingId);

}
