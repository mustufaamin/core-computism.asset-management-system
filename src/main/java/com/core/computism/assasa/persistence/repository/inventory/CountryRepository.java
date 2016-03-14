package com.core.computism.assasa.persistence.repository.inventory;

import com.core.computism.assasa.persistence.entity.inventory.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Mustafa Amin on 3/13/2016.
 */
public interface CountryRepository extends JpaRepository<Country,Long> {
}
