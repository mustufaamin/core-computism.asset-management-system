package com.core.computism.assasa.persistence.repository.inventory;

import com.core.computism.assasa.persistence.entity.pos.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by VD on 2/24/2016.
 */
public interface SupplierRepository extends JpaRepository<Supplier,Long> {
}
