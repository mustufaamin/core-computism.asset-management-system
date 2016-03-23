package com.core.computism.assasa.persistence.repository.pos;

import com.core.computism.assasa.persistence.entity.pos.PosPaymentType;
import com.core.computism.assasa.persistence.entity.pos.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by VD on 3/23/2016.
 */
public interface PosPaymentTypeRepository extends JpaRepository<PosPaymentType,Long> {
}
