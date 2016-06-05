package com.core.computism.assasa.persistence.repository.common;

import com.core.computism.assasa.persistence.entity.common.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by VD on 5/2/2016.
 */
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
