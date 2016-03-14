package com.core.computism.assasa.persistence.repository.inventory;

import com.core.computism.assasa.persistence.entity.inventory.City;
import com.core.computism.assasa.persistence.entity.inventory.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by VD on 3/13/2016.
 */
public interface CityRepository extends JpaRepository<City,Long> {
}
