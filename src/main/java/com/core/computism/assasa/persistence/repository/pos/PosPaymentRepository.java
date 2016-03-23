package com.core.computism.assasa.persistence.repository.pos;

import com.core.computism.assasa.persistence.entity.pos.PosPayment;
import com.core.computism.assasa.persistence.entity.pos.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by M.Mustufa Amin Shah on 3/23/2016.
 */
public interface PosPaymentRepository extends JpaRepository<PosPayment,Long> {
}
